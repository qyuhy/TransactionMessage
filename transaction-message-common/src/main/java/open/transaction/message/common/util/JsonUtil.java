package open.transaction.message.common.util;

import com.alibaba.fastjson.JSONObject;

/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 16:23
 * Email: qyuhy@qq.com
 */
public class JsonUtil {
    /**
     * 把对象转换为JSON字符串
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj) {
        return JSONObject.toJSONString(obj);
    }

}
