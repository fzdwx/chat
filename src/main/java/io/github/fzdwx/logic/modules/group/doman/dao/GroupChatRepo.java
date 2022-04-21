package io.github.fzdwx.logic.modules.group.doman.dao;

import io.github.fzdwx.inf.middleware.db.BaseRepo;
import io.github.fzdwx.logic.modules.group.doman.dao.mapper.GroupChatMapper;
import io.github.fzdwx.logic.modules.group.doman.entity.GroupChat;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:likelovec@gmail.com">韦朕</a>
 * @date 2022/4/21 16:59
 */
@Repository
public class GroupChatRepo extends BaseRepo<GroupChatMapper, GroupChat> {
}