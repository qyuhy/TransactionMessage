package open.transaction.message.service;

import open.transaction.message.api.TransactionMessageService;
import open.transaction.message.model.TransactionMessage;
import open.transaction.message.mq.MqClient;
import open.transaction.message.mq.vo.MqSendResult;
import open.transaction.message.store.MessageStore;
import open.transaction.message.store.util.TransactionMessageUtil;
import open.transaction.message.store.vo.SaveResult;
import open.transaction.message.vo.ConfirmResult;
import open.transaction.message.vo.Message;
import open.transaction.message.vo.RollbackResult;
import open.transaction.message.vo.SendResult;
import open.transaction.message.common.exception.TransactionMessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 13:25
 * Email: qyuhy@qq.com
 */
public class DefaultTransactionMessageService implements TransactionMessageService{
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 消息持久化组件
     */
    protected MessageStore messageStore;
    /**
     * MQ消息组件
     */
    protected MqClient mqClient;

    public DefaultTransactionMessageService(MessageStore messageStore, MqClient mqClient) {
        this.messageStore = messageStore;
        this.mqClient = mqClient;
    }

    public SendResult sendPrepareMessage(Message msg) throws TransactionMessageException {
        SaveResult saveResult = this.messageStore.save(TransactionMessageUtil.newTransactionMessage(msg));
        SendResult result = new SendResult();
        result.setOk(saveResult.isOk());
        result.setMessageId(saveResult.getMessageId());
        return result;
    }

    public ConfirmResult confirm(String messageId) throws TransactionMessageException {
        //发送到mq，并更新表结构
        TransactionMessage transactionMessage = this.messageStore.selectByMessageId(messageId);
        MqSendResult send = this.mqClient.send(transactionMessage.getQueue(), transactionMessage.getMessageBody().getBytes());
        ConfirmResult result = new ConfirmResult();
        result.setOk(send.isOk());
        return result;
    }

    public RollbackResult rollback(String messageId) throws TransactionMessageException {
        return null;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

    public MqClient getMqClient() {
        return mqClient;
    }

    public void setMqClient(MqClient mqClient) {
        this.mqClient = mqClient;
    }
}
