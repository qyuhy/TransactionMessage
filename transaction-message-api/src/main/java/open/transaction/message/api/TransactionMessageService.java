package open.transaction.message.api;

import open.transaction.message.vo.ConfirmResult;
import open.transaction.message.vo.Message;
import open.transaction.message.vo.RollbackResult;
import open.transaction.message.vo.SendResult;
import open.transaction.message.common.exception.TransactionMessageException;

/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 11:58
 * Email: qyuhy@qq.com
 */
public interface TransactionMessageService {

    SendResult sendPrepareMessage(final Message msg) throws TransactionMessageException;

    ConfirmResult confirm(String messageId) throws TransactionMessageException;

    RollbackResult rollback(String messageId) throws TransactionMessageException;
}
