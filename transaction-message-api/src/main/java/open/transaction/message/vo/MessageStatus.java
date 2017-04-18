package open.transaction.message.vo;

/**
 * User: hyman
 * Date: 2017/4/12 0012
 * Time: 17:53
 * Email: qyuhy@qq.com
 */
public enum MessageStatus {
    /**预发送状态，进入持久化存储系统**/
    PREPARE,
    /**提交状态，发送到消息中间件系统**/
    CONFIRM,
    /**回款状态,取消发送到消息中间件系统**/
    ROLLBACK,
    /**CONFIRM之后的最终状态，标识消息已经被消费端成功消费**/
    DONE;
}
