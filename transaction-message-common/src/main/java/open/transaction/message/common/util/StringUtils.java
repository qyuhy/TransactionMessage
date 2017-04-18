package open.transaction.message.common.util;

import java.util.UUID;

/**
 * User: hyman
 * Date: 2017/4/17 0017
 * Time: 14:12
 * Email: qyuhy@qq.com
 */
public class StringUtils {
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.uuid());
    }

}
