package open.transaction.message.api;


import open.transaction.message.api.business.LocalTransactionExecuter;
import open.transaction.message.vo.Message;
import open.transaction.message.vo.SendResult;
import open.transaction.message.common.exception.TransactionMessageException;

/**
 * User: hyman
 * Date: 2017/4/12 0012
 * Time: 18:55
 * Email: qyuhy@qq.com
 */
public interface TransactionMessageProduct extends TransactionMessageService{

    SendResult sendMessageInTransaction(final Message msg, LocalTransactionExecuter localTransactionExecuter
            , final Object arg) throws TransactionMessageException;

}
