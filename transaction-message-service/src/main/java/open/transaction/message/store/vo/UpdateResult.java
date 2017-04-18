package open.transaction.message.store.vo;

/**
 * User: hyman
 * Date: 2017/4/17 0017
 * Time: 14:33
 * Email: qyuhy@qq.com
 */
public class UpdateResult {
    private boolean ok;
    private String message;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
