package org.atomicoke.logic.msg.domain.resp;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.atomicoke.inf.common.contants.ChatConst;

import java.time.LocalDateTime;

/**
 * @author <a href="mailto:likelovec@gmail.com">fzdwx</a>
 * @date 2022/4/10 17:20
 */
@Data
@Slf4j
@Accessors(chain = true)
public class NotifyResp {

    /**
     * 当前信箱所属人id
     */
    private String boxOwnerId;

    /**
     * 当前信箱所属人 全局seq(每收到或发送一条消息则加1)
     */
    private String boxOwnerSeq;

    /**
     * 申请id
     */
    private String requestId;
    /**
     * 消息发送人id
     */
    private String fromId = String.valueOf(ChatConst.Sys.SYS_ID);
    /**
     * 消息发送人用户名
     */
    private String fromUname = ChatConst.Sys.SYS_NAME;
    /**
     * 消息发送人头像
     */
    //todo 系统头像
    private String fromAvatar;
    /**
     * 实际接收人id
     */
    private String toId;
    /**
     * @see ChatConst.Notify
     */
    private int contactType;

    /**
     * 消息发送者的类型 1:用户 2:系统
     */
    private int msgFrom = ChatConst.MsgFrom.SYS;

    /**
     * 操作时间
     */
    private LocalDateTime handlerTime;

    /**
     * 操作结果 1:未操作 2:同意 3:拒绝
     */
    private Integer handlerResult;

    /**
     * 消息
     */
    private Message message;

    @Data
    public static class Message {

        /**
         * 申请人id
         */
        private String operatorId;

        /**
         * 申请人头像
         */
        private String operatorAvatar;

        /**
         * 申请人昵称
         */
        private String operatorNickName;
    }
}