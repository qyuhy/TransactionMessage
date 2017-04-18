package open.transaction.message.mq;

import open.transaction.message.mq.vo.MqSendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: hyman
 * Date: 2017/4/17 0017
 * Time: 15:42
 * Email: qyuhy@qq.com
 */
public abstract class AbstractMqClient implements MqClient{
    private Logger logger = LoggerFactory.getLogger(AbstractMqClient.class);
    private static String LOG_PREFIX = "AbstractMqClient::";

    public MqSendResult send(String queue, byte[] bytes) {
        logger.info("发送消息:"+new String(bytes));
        return doSend(queue, bytes);
    }

    protected abstract MqSendResult doSend(String queue, byte[] bytes);

}
