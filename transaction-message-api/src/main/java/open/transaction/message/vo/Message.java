package open.transaction.message.vo;

import open.transaction.message.common.exception.TransactionMessageException;
import open.transaction.message.common.util.JsonUtil;

import java.io.Serializable;

/**
 * User: hyman
 * Date: 2017/4/12 0012
 * Time: 17:50
 * Email: qyuhy@qq.com
 */
public class Message implements Serializable{
    /**
     * 时间戳
     * 客户端时间戳，可以根据客户端时间和数据持久化时间戳算出两个时间戳的时间
     */
    private Long time = System.currentTimeMillis();
    /**
     * 消息体序列化方式
     */
    private String messageSerializableType;
    /**
     * 消息体
     */
    private Object body;
    /**
     * 要发送到消息的队列名称
     */
    private String queue;
    /**
     *业务活动类别
     *每个类别的前三位对应到每个业务类型，后三位是对此业务类型的具体操作；
     * 如002代表支付，而002001代表支付申请中的冻结部分
     */
    private String businessType;
    /**
     * 业务数据的ID或可以唯一定位到业务数据的Key
     */
    private String businessId;
    /**
     * 业务会查协议
     */
    private String businessCheckListenerProtocol;
    /**
     * 业务回查数据;
     */
    private Object businessCheckListenerData;

    public Message(){};

    private Message(MessageBuilder messageBuilder){
        this.time = messageBuilder.time;
        this.messageSerializableType = messageBuilder.messageSerializableType.name();
        this.body = messageBuilder.body;
        this.queue = messageBuilder.queue;
        this.businessType = messageBuilder.businessType;
        this.businessId = messageBuilder.businessId;
        this.businessCheckListenerProtocol = messageBuilder.checkProtocol.name();
        this.businessCheckListenerData = messageBuilder.businessCheckListenerData;
    }


    public static class MessageBuilder{
        private final String DEFAULT_QUEUE = "TRANSACTION_MESSAGE_QUEUE";
        private long time = System.currentTimeMillis();
        private MessageSerializableType messageSerializableType = MessageSerializableType.JSON;
        private Object body;
        private String queue = DEFAULT_QUEUE;
        private String businessType;
        private String businessId;
        private BusinessCheckListenerProtocolEnum checkProtocol = BusinessCheckListenerProtocolEnum.DUBBO;
        private Object businessCheckListenerData;

        public MessageBuilder(String businessType,String businessId,Object body,Object businessCheckListenerData){
            this.businessType = businessType;
            this.businessId = businessId;
            this.body = body;
            this.businessCheckListenerData = businessCheckListenerData;
        }

        public MessageBuilder messageSerializableType(MessageSerializableType messageSerializableType){
            this.messageSerializableType = messageSerializableType;
            return this;
        }

        public MessageBuilder queue(String queue){
            this.queue = queue;
            return this;
        }

        public MessageBuilder checkProtocol(BusinessCheckListenerProtocolEnum businessCheckListenerProtocolEnum){
            this.checkProtocol = businessCheckListenerProtocolEnum;
            return this;
        }

        public Message build(){
            //构建
            switch (messageSerializableType){
                case JSON:
                    this.body = JsonUtil.toJson(this.body);
                    break;
                default:
                    throw TransactionMessageException.UNSUPPORT_SERIALIZABLE.newInstance("不支持的%s序列化方式",messageSerializableType.name());
            }
            return new Message(this);
        }
    }

    public Object getBody() {
        return body;
    }

    public String getQueue() {
        return queue;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getBusinessId() {
        return businessId;
    }

    public Long getTime() {
        return time;
    }

    public String getBusinessCheckListenerProtocol() {
        return businessCheckListenerProtocol;
    }

    public Object getBusinessCheckListenerData() {
        return businessCheckListenerData;
    }

    public String getMessageSerializableType() {
        return messageSerializableType;
    }
}
