package io.github.fzdwx.logic.msg.offline;

import io.github.fzdwx.inf.middleware.redis.Redis;
import io.github.fzdwx.logic.msg.ws.packet.resp.ChatMessageResp;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:likelovec@gmail.com">韦朕</a>
 * @date 2022/4/12 15:48
 */
@Component
public class OfflineMessageManager implements InitializingBean {

    // 未读消息最小的id
    private final static String MIN_ID_KEY_PREFIX = "msg:minId:";
    // 未读消息的数量
    private final static String MEG_SUM_KEY_PREFIX = "msg:sum:";

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    /**
     * key: offline:msg:userId
     * filed: fromId | value:  min message id
     */
    public static void push(final ChatMessageResp chatMessageResp) {
        setMinMessageId(chatMessageResp);
        incrMessageSum(chatMessageResp);
    }

    private static void incrMessageSum(final ChatMessageResp chatMessageResp) {
        String key = incrKey(chatMessageResp);
        Redis.hIncr(key, chatMessageResp.getFromId());
    }

    private static void setMinMessageId(final ChatMessageResp chatMessageResp) {
        String key = minIdKey(chatMessageResp);

        // 当 msgId 为null 或 msgId > minMsgId 时，更新 msgId
        final String msgId = Redis.hGet(key, chatMessageResp.getFromId());
        if (msgId == null || Long.parseLong(msgId) > chatMessageResp.getMinMessageId()) {
            Redis.hSet(key, chatMessageResp.getFromId(), chatMessageResp.getMinMessageId().toString());
        }
    }

    private static String minIdKey(ChatMessageResp chatMessageResp) {
        return MIN_ID_KEY_PREFIX + chatMessageResp.getToId();
    }

    private static String incrKey(ChatMessageResp chatMessageResp) {
        return MEG_SUM_KEY_PREFIX + chatMessageResp.getToId();
    }
}