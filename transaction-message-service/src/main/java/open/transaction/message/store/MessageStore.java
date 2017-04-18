package open.transaction.message.store;

import open.transaction.message.model.TransactionMessage;
import open.transaction.message.store.vo.SaveResult;
import open.transaction.message.store.vo.UpdateResult;

/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 11:31
 * Email: qyuhy@qq.com
 */
public interface MessageStore {
    /**
     * 持久化消息
     * @param transactionMessage
     * @return
     */
    SaveResult save(TransactionMessage transactionMessage);

    /**
     *根据消息ID查询消息
     * @param messageId
     * @return
     */
    TransactionMessage selectByMessageId(String messageId);

    /**
     * 根据消息Id更新消息
     * @param messageId
     * @param updatedTransactionMessage
     * @return
     */
    UpdateResult updateByMessageId(String messageId, TransactionMessage updatedTransactionMessage);
}
