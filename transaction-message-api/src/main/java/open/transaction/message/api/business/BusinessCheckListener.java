package open.transaction.message.api.business;

/**
 * User: hyman
 * Date: 2017/4/12 0012
 * Time: 19:21
 * Email: qyuhy@qq.com
 */
public interface BusinessCheckListener {
    /**
     * 未知
     */
    int UNKNOWUN = 0;

    /**
     * 已执行
     */
    int DONE = 1;

    /**
     * 未执行
     */
    int NOT_DONE = 2;

    /**
     * 根据业务类型与业务号，反查业务活动是否执行成功
     * @param businessType 业务类型
     * @param businessId 业务ID
     * @return
     */
    int isDone(String businessType, String businessId);
}
