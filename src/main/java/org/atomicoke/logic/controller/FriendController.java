package org.atomicoke.logic.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.atomicoke.inf.common.web.model.Rest;
import org.atomicoke.inf.common.web.model.UserInfo;
import org.atomicoke.logic.modules.friend.domain.model.FriendApplyReq;
import org.atomicoke.logic.modules.friend.domain.model.FriendHandleReq;
import org.atomicoke.logic.modules.friend.service.FriendService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 朋友
 *
 * @author <a href="mailto:likelovec@gmail.com">韦朕</a>
 * @date 2022/4/17 22:32
 */
@RestController
@RequestMapping("friend")
@AllArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @PostMapping("apply")
    public void apply(UserInfo userInfo, @Valid @RequestBody FriendApplyReq req) {
        Rest.of(() -> friendService.apply(userInfo, req));
    }

    @PostMapping("handle")
    public void handle(UserInfo userInfo, @Valid @RequestBody FriendHandleReq req) {
        Rest.of(() -> friendService.handle(userInfo, req));
    }
}