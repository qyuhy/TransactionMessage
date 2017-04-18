package open.transaction.message.vo;

import java.io.Serializable;

/**
 * User: hyman
 * Date: 2017/4/12 0012
 * Time: 19:31
 * Email: qyuhy@qq.com
 */
public class SendResult implements Serializable{
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
