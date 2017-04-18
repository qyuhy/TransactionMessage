package open.transaction.message.model;

import java.util.Date;

public class TransactionMessage {
    public static enum ALREADY_DEAD_ENUM{
        YES,NO
    }

    /**
     * 表：transaction_message
     * 字段：id
     * 注释：ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 表：transaction_message
     * 字段：message_id
     * 注释：消息ID
     *
     * @mbggenerated
     */
    private String messageId;

    /**
     * 表：transaction_message
     * 字段：business_id
     * 注释：业务ID
     *
     * @mbggenerated
     */
    private String businessId;

    /**
     * 表：transaction_message
     * 字段：business_type
     * 注释：业务类型
     *
     * @mbggenerated
     */
    private String businessType;

    /**
     * 表：transaction_message
     * 字段：create_time
     * 注释：消息创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 表：transaction_message
     * 字段：sended_time
     * 注释：消息发送到MQ时间
     *
     * @mbggenerated
     */
    private Date sendedTime;

    /**
     * 表：transaction_message
     * 字段：done_time
     * 注释：消息结束最终时间
     *
     * @mbggenerated
     */
    private Date doneTime;

    /**
     * 表：transaction_message
     * 字段：message_status
     * 注释：消息状态
     *
     * @mbggenerated
     */
    private String messageStatus;

    /**
     * 表：transaction_message
     * 字段：queue
     * 注释：队列
     *
     * @mbggenerated
     */
    private String queue;

    /**
     * 表：transaction_message
     * 字段：try_times
     * 注释：consumer端没有确认消息重发次数
     *
     * @mbggenerated
     */
    private Integer tryTimes;

    /**
     * 表：transaction_message
     * 字段：already_dead
     * 注释：是否死亡
     *
     * @mbggenerated
     */
    private String alreadyDead;

    /**
     * 表：transaction_message
     * 字段：check_protocol
     * 注释：回查协议
     *
     * @mbggenerated
     */
    private String checkProtocol;

    /**
     * 表：transaction_message
     * 字段：message_body_type
     * 注释：消息类型
     *
     * @mbggenerated
     */
    private String messageBodyType;

    /**
     * 表：transaction_message
     * 字段：version
     * 注释：版本号
     *
     * @mbggenerated
     */
    private Integer version;

    /**
     * 表：transaction_message
     * 字段：client_time
     * 注释：客户端时间
     *
     * @mbggenerated
     */
    private Long clientTime;

    /**
     * 表：transaction_message
     * 字段：update_time
     * 注释：更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 消息内容
     */
    private String messageBody;
    /**
     * check附属数据
     */
    private String checkAttachment;
    /**
     * 重试配置
     */
    private String tryConfig;


    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getCheckAttachment() {
        return checkAttachment;
    }

    public void setCheckAttachment(String checkAttachment) {
        this.checkAttachment = checkAttachment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendedTime() {
        return sendedTime;
    }

    public void setSendedTime(Date sendedTime) {
        this.sendedTime = sendedTime;
    }

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus == null ? null : messageStatus.trim();
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue == null ? null : queue.trim();
    }

    public Integer getTryTimes() {
        return tryTimes;
    }

    public void setTryTimes(Integer tryTimes) {
        this.tryTimes = tryTimes;
    }

    public String getAlreadyDead() {
        return alreadyDead;
    }

    public void setAlreadyDead(String alreadyDead) {
        this.alreadyDead = alreadyDead;
    }

    public String getCheckProtocol() {
        return checkProtocol;
    }

    public void setCheckProtocol(String checkProtocol) {
        this.checkProtocol = checkProtocol == null ? null : checkProtocol.trim();
    }

    public String getMessageBodyType() {
        return messageBodyType;
    }

    public void setMessageBodyType(String messageBodyType) {
        this.messageBodyType = messageBodyType == null ? null : messageBodyType.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getClientTime() {
        return clientTime;
    }

    public void setClientTime(Long clientTime) {
        this.clientTime = clientTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTryConfig() {
        return tryConfig;
    }

    public void setTryConfig(String tryConfig) {
        this.tryConfig = tryConfig;
    }
}