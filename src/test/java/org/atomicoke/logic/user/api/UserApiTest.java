package org.atomicoke.logic.user.api;

import org.atomicoke.logic.msg.domain.resp.NotifyResp;
import org.atomicoke.logic.msg.sync.MessageSyncer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author <a href="mailto:likelovec@gmail.com">fzdwx</a>
 * @date 2022/4/17 21:58
 */
@SpringBootTest
@AutoConfigureMockMvc
class UserApiTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test() throws Exception {
        mockMvc.perform(
                get("/user/getAll")
        ).andDo(print());
    }

    @Test
    void test1() throws Exception {
        NotifyResp resp = new NotifyResp();
        resp.setBoxOwnerId("1111");
        resp.setBoxOwnerSeq("1");
        resp.setContactType(11001);
        resp.setFromId("0");
        resp.setFromUname("系统");
        resp.setRequestId("123123123");
        resp.setHandlerTime(LocalDateTime.now());
        resp.setMsgFrom(2);
        MessageSyncer.saveNotifyToMongo(resp);
    }
}