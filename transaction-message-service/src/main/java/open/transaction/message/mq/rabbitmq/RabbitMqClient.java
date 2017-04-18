package open.transaction.message.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import open.transaction.message.mq.AbstractMqClient;
import open.transaction.message.mq.vo.MqSendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * User: hyman
 * Date: 2017/4/17 0017
 * Time: 15:45
 * Email: qyuhy@qq.com
 */
public class RabbitMqClient extends AbstractMqClient{
    private Logger logger = LoggerFactory.getLogger(RabbitMqClient.class);

    private String host = "127.0.0.1";
    private Integer port = 5672;
    private String userName = "ccmtjf@2016";
    private String password = "UFO123456";
    private String virtualHost = "ccmtjfvhost";
    private String exchange = "zsjrExchange";

    private Connection connection = null;
    private Channel channel = null;


    protected MqSendResult doSend(String queue, byte [] bytes) {
        //TODO 优化，换成链接池实现
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(userName);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);

        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(exchange, "direct", true);
            channel.queueDeclare(queue,true,false,false,null);
            channel.basicPublish(exchange,queue,null,bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MqSendResult mqSendResult = new MqSendResult();
        mqSendResult.setOk(true);
        return mqSendResult;
    }

    public static void main(String[] args) throws InterruptedException {
        RabbitMqClient mqClient = new RabbitMqClient();
        mqClient.send("COMMON_SEND","hello".getBytes());
    }

}
