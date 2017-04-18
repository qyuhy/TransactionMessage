package open.transaction.message.api;

import open.transaction.message.api.business.LocalTransactionExecuter;
import open.transaction.message.vo.LocalTransactionStatus;
import open.transaction.message.vo.Message;
import open.transaction.message.vo.SendResult;
import open.transaction.message.common.exception.TransactionMessageException;

/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 11:27
 * Email: qyuhy@qq.com
 */
public class DefaultTransactionMessageProduct extends AbstractTransactionMessageProduct{
    public DefaultTransactionMessageProduct(TransactionMessageService transactionMessageServiceProxy) {
        super(transactionMessageServiceProxy);
    }

    public SendResult sendMessageInTransaction(Message msg, LocalTransactionExecuter localTransactionExecuter, Object arg) throws TransactionMessageException {
        if(msg == null){
            throw TransactionMessageException.REQUEST_PARAM_IS_NULL.newInstance("消息不能为空!",null);
        }
        //发送预消息
        SendResult sendResult = this.transactionMessageServiceProxy.sendPrepareMessage(msg);
        if(sendResult == null || !sendResult.isOk()){
            return sendResult;
        }
        //执行本地事务
        LocalTransactionStatus localTransactionStatus = localTransactionExecuter.execute(msg, arg);
        if(localTransactionStatus == LocalTransactionStatus.CONFIRM){
            //dubbo代理可以把此方法配置为异步方法
            this.transactionMessageServiceProxy.confirm(sendResult.getMessageId());
            return sendResult;
        }
        this.transactionMessageServiceProxy.rollback(sendResult.getMessageId());
        return sendResult;
    }
}
