package open.transaction.message.common.idgenerator.impl;

import open.transaction.message.common.idgenerator.IdGenerator;
import open.transaction.message.common.util.StringUtils;

/**
 * User: hyman
 * Date: 2017/4/17 0017
 * Time: 14:11
 * Email: qyuhy@qq.com
 */
public class UuidIdGenerator implements IdGenerator{

    public String getNextValue() {
        return StringUtils.uuid();
    }

}
