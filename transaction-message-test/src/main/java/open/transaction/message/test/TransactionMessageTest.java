package open.transaction.message.test;

import open.transaction.message.api.TransactionMessageProduct;
import open.transaction.message.api.business.LocalTransactionExecuter;
import open.transaction.message.vo.LocalTransactionStatus;
import open.transaction.message.vo.Message;
import open.transaction.message.vo.SendResult;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: hyman
 * Date: 2017/4/18 0018
 * Time: 19:48
 * Email: qyuhy@qq.com
 * To change this template use File | Settings | File Templates.
 */
public class TransactionMessageTest {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring-dubbo-consumer.xml"
        );
        TransactionMessageProduct product = context.getBean(TransactionMessageProduct.class);
        String busType = "000100";
        String busId = "001";
        Object body = new Account(1000L);
        Message.MessageBuilder messageBuilder = new Message.MessageBuilder(busType,busId,body,"hello");
        Message message = messageBuilder.queue("COMMON_SEND").build();
        SendResult sendResult = product.sendMessageInTransaction(message, new LocalTransactionExecuter() {
            public LocalTransactionStatus execute(Message message, Object agrs) {
                System.out.println("执行本地事务.........");
                return LocalTransactionStatus.CONFIRM;
            }
        }, null);


    }


    public static class Account{
        private long balance;

        public Account(long balance) {
            this.balance = balance;
        }

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }
    }
}
