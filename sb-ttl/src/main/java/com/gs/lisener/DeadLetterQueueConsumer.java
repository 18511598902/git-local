/**
 * 版权所有 2019 山东新北洋信息技术股份有限公司
 * 保留所有权利。
 */
package com.gs.lisener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

import static com.gs.common.config.RabbitMQConfig.DEAD_LETTER_QUEUEA_NAME;
import static com.gs.common.config.RabbitMQConfig.DEAD_LETTER_QUEUEB_NAME;

/**
 * @author : gs
 * @ClassName : DeadLetterQueueConsumer
 * @Description : 类描述
 * @Date: 2020-07-02 16:36
 */

@Slf4j
@Component
public class DeadLetterQueueConsumer {

    @RabbitListener(queues = DEAD_LETTER_QUEUEA_NAME)
    public void receiveA(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        log.info("当前时间：{},死信队列A收到消息：{}", new Date().toString(), msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(queues = DEAD_LETTER_QUEUEB_NAME)
    public void receiveB(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        log.info("当前时间：{},死信队列B收到消息：{}", new Date().toString(), msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }


    @RabbitListener(queues = "testQueue")
    public void testQueue(Message message, Channel channel)  {
        try {
            String msg = new String(message.getBody());
            log.info("当前时间：{},死信队列B收到消息：{}", new Date().toString(), msg);
            throw new Exception("cs");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
