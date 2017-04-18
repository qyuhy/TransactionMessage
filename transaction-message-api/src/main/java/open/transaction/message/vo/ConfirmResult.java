package open.transaction.message.vo;

import java.io.Serializable;

/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 10:08
 * Email: qyuhy@qq.com
 */
public class ConfirmResult implements Serializable{
    private boolean ok;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
