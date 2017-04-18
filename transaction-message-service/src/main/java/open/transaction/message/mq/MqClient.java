package open.transaction.message.mq;

import open.transaction.message.mq.vo.MqSendResult;

/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 11:32
 * Email: qyuhy@qq.com
 */
public interface MqClient {
    public MqSendResult send(String queue, byte [] bytes);
}
