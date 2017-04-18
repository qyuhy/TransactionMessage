package open.transaction.message.store.vo;

/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 19:54
 * Email: qyuhy@qq.com
 */
public class SaveResult {
    private boolean ok;
    private String messageId;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
