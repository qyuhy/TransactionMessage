package open.transaction.message.api;

import open.transaction.message.vo.ConfirmResult;
import open.transaction.message.vo.Message;
import open.transaction.message.vo.RollbackResult;
import open.transaction.message.vo.SendResult;
import open.transaction.message.common.exception.TransactionMessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 11:23
 * Email: qyuhy@qq.com
 */
public abstract class AbstractTransactionMessageProduct implements TransactionMessageProduct {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * dubbo远程服务代理
     */
    protected TransactionMessageService transactionMessageServiceProxy;

    public AbstractTransactionMessageProduct(TransactionMessageService transactionMessageServiceProxy){
        this.transactionMessageServiceProxy = transactionMessageServiceProxy;
    }

    public SendResult sendPrepareMessage(Message msg) throws TransactionMessageException {
        return transactionMessageServiceProxy.sendPrepareMessage(msg);
    }

    public ConfirmResult confirm(String messageId) throws TransactionMessageException {
        return transactionMessageServiceProxy.confirm(messageId);
    }

    public RollbackResult rollback(String messageId) throws TransactionMessageException {
        return transactionMessageServiceProxy.rollback(messageId);
    }
}
