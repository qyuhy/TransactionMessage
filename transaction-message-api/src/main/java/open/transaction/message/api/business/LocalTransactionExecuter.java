package open.transaction.message.api.business;


import open.transaction.message.vo.LocalTransactionStatus;
import open.transaction.message.vo.Message;

/**
 * User: hyman
 * Date: 2017/4/12 0012
 * Time: 19:36
 * Email: qyuhy@qq.com
 */
public interface LocalTransactionExecuter {
    LocalTransactionStatus execute(Message message, Object agrs);
}
