package open.transaction.message.store.exception;

import open.transaction.message.common.exception.TransactionMessageException;

/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 20:09
 * Email: qyuhy@qq.com
 */
public class StoreException extends TransactionMessageException {

    public static final StoreException MESSAGE_PERSISTENCE = new StoreException(
            200001,"消息持久化失败"
    );

    public StoreException() {
    }

    public StoreException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    public StoreException(int code, String msg) {
        super(code, msg);
    }

}
