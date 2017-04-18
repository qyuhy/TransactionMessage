package open.transaction.message.store;

import open.transaction.message.common.idgenerator.IdGenerator;
import open.transaction.message.model.TransactionMessage;
import open.transaction.message.store.vo.SaveResult;
import open.transaction.message.store.vo.UpdateResult;

/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 19:57
 * Email: qyuhy@qq.com
 */
public abstract class AbstractMessageStore implements MessageStore{
    protected IdGenerator idGenerator;

    protected AbstractMessageStore(IdGenerator idGenerator){
        this.idGenerator = idGenerator;
    }

    public SaveResult save(TransactionMessage transactionMessage) {
        return this.doSave(transactionMessage);
    }

    protected abstract SaveResult doSave(TransactionMessage transactionMessage);

    public UpdateResult updateByMessageId(String messageId, TransactionMessage updatedTransactionMessage){
        return doUpdateByMessageId(messageId,updatedTransactionMessage);
    }

    protected abstract UpdateResult doUpdateByMessageId(String messageId, TransactionMessage updatedTransactionMessage);

    public TransactionMessage selectByMessageId(String messageId){
        return this.doSelectByMessageId(messageId);
    }

    protected abstract TransactionMessage doSelectByMessageId(String messageId);
}
