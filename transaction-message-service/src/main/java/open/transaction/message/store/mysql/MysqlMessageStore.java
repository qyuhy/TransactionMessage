package open.transaction.message.store.mysql;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import open.transaction.message.common.idgenerator.IdGenerator;
import open.transaction.message.common.idgenerator.impl.UuidIdGenerator;
import open.transaction.message.model.TransactionMessage;
import open.transaction.message.store.AbstractMessageStore;
import open.transaction.message.store.mysql.mapper.TransactionMessageMapper;
import open.transaction.message.store.vo.SaveResult;
import open.transaction.message.store.vo.UpdateResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * User: hyman
 * Date: 2017/4/13 0013
 * Time: 19:45
 * Email: qyuhy@qq.com
 */
public class MysqlMessageStore extends AbstractMessageStore{
    private Logger logger = LoggerFactory.getLogger(MysqlMessageStore.class);
    @Autowired
    private TransactionMessageMapper transactionMessageMapper;

    private String LOG_SAVE_PREFIX = "MYSQL消息持久化:";

    protected MysqlMessageStore(IdGenerator idGenerator) {
        super(idGenerator);
    }

    protected SaveResult doSave(TransactionMessage transactionMessage) {
        SaveResult saveResult = new SaveResult();
        String messageId = this.idGenerator.getNextValue();
        transactionMessage.setMessageId(messageId);
        int row = transactionMessageMapper.insert(transactionMessage);
        if(row <= 0){
            logger.error(LOG_SAVE_PREFIX + "影响行数{}",row);
            saveResult.setOk(false);
            return saveResult;
        }
        saveResult.setOk(true);
        saveResult.setMessageId(messageId);
        return saveResult;
    }


    protected UpdateResult doUpdateByMessageId(String messageId, TransactionMessage updatedTransactionMessage) {
        TransactionMessage where = new TransactionMessage();
        where.setMessageId(messageId);
        EntityWrapper wrapper = new EntityWrapper<TransactionMessage>(where);
        int row = transactionMessageMapper.update(updatedTransactionMessage, wrapper);
        UpdateResult updateResult = new UpdateResult();
        if(row <= 0){
            logger.error(LOG_SAVE_PREFIX + "影响行数{}",row);
            updateResult.setOk(false);
            updateResult.setMessage(LOG_SAVE_PREFIX + "影响行数" + row);
            return updateResult;
        }
        updateResult.setOk(true);
        return updateResult;
    }

    @Override
    protected TransactionMessage doSelectByMessageId(String messageId) {
        TransactionMessage where = new TransactionMessage();
        where.setMessageId(messageId);
        return transactionMessageMapper.selectOne(where);
    }

    public static void main(String[] args) {
        MysqlMessageStore store = new MysqlMessageStore(new UuidIdGenerator());
        store.updateByMessageId("hello",new TransactionMessage());
    }

}
