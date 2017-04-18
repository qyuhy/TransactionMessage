package open.transaction.message.common.exception;

/**
 * User: hyman
 * Date: 2017/4/12 0012
 * Time: 18:22
 * Email: qyuhy@qq.com
 */
public class TransactionMessageException extends RuntimeException{

    public static final TransactionMessageException REQUEST_PARAM_IS_NULL = new TransactionMessageException(
      200001,"请求参数不能为空"
    );
    public static final TransactionMessageException UNSUPPORT_SERIALIZABLE = new TransactionMessageException(
            200002,"不支持的序列化方式"
    );


    /**
     * 异常信息
     */
    protected String msg;
    /**
     * 异常编码
     * 统一格式：A-BB-CCC
     * A:错误级别，如1代表系统级错误，2代表服务级错误；
     * B:项目或模块名称，一般公司不会超过99个项目；
     * C:具体错误编号，自增即可，一个项目999种错误应该够用
     */
    protected int code;


    public TransactionMessageException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public TransactionMessageException() {
        super();
    }

    public TransactionMessageException(String message) {
        super(message);
    }

    public TransactionMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionMessageException(Throwable cause) {
        super(cause);
    }

    /**
     * 生成一个新实例
     * @param msgFormat
     * @param args
     * @return
     */
    public TransactionMessageException newInstance(String msgFormat, Object... args) {
        return new TransactionMessageException(this.code, msgFormat, args);
    }

}
