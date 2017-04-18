package open.transaction.message.store.util;

import open.transaction.message.common.util.JsonUtil;
import open.transaction.message.model.TransactionMessage;
import open.transaction.message.store.vo.TryConfig;
import open.transaction.message.vo.Message;
import open.transaction.message.vo.MessageStatus;

import java.util.Date;

import static open.transaction.message.common.exception.TransactionMessageException.UNSUPPORT_SERIALIZABLE;

/**
 * User: hyman
 * Date: 2017/4/17 0017
 * Time: 18:07
 * Email: qyuhy@qq.com
 */
public class TransactionMessageUtil {
    public static int DEFAULT_TRY_TIMES = 0;

    public static TransactionMessage newTransactionMessage(Message message){
        TransactionMessage transactionMessage = new TransactionMessage();
        transactionMessage.setAlreadyDead(TransactionMessage.ALREADY_DEAD_ENUM.NO.name());
        transactionMessage.setBusinessId(message.getBusinessId());
        transactionMessage.setBusinessType(message.getBusinessType());
        transactionMessage.setClientTime(message.getTime());
        transactionMessage.setMessageBodyType(message.getMessageSerializableType());
        transactionMessage.setMessageBody(handlerBody(message.getBody()));
        transactionMessage.setVersion(1);
        transactionMessage.setCheckProtocol(message.getBusinessCheckListenerProtocol());
        transactionMessage.setCheckAttachment(message.getBusinessCheckListenerData() == null ? null : message.getBusinessCheckListenerData().toString());
        transactionMessage.setQueue(message.getQueue());
        transactionMessage.setMessageStatus(MessageStatus.PREPARE.name());
        Date date = new Date();
        transactionMessage.setCreateTime(date);
        transactionMessage.setUpdateTime(date);
        transactionMessage.setTryTimes(DEFAULT_TRY_TIMES);
        transactionMessage.setTryConfig(JsonUtil.toJson(new TryConfig()));
        transactionMessage.setUpdateTime(date);
        return transactionMessage;
    }

    public static Message transactionMessageConvertMessage(TransactionMessage transactionMessage){
        return null;
    }

    private static String handlerBody(Object body){
        if(body == null){
            return null;
        }
        if(body instanceof String){
            return body.toString();
        }
        throw UNSUPPORT_SERIALIZABLE.newInstance("不支持%s的序列化方式",body);
    }
}
