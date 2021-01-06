/**
 * 版权所有 2019 山东新北洋信息技术股份有限公司
 * 保留所有权利。
 */
package com.gs.sender;

import com.gs.common.enums.DelayTypeEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.gs.common.config.RabbitMQConfig.DELAY_EXCHANGE_NAME;
import static com.gs.common.config.RabbitMQConfig.DELAY_QUEUEA_ROUTING_KEY;
import static com.gs.common.config.RabbitMQConfig.DELAY_QUEUEB_ROUTING_KEY;

/**
 * @author : gs
 * @ClassName : DelayMessageSender
 * @Description : 发送者
 * @Date: 2020-07-02 16:37
 */

@Component
public class DelayMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg, Integer type) {
        if (DelayTypeEnum.DELAY_10s.getCode().equals(type)) {
            rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_QUEUEA_ROUTING_KEY, msg, message -> {
                message.getMessageProperties().setExpiration("30000");
                return message;
            });
        } else {
            rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_QUEUEB_ROUTING_KEY, msg);
        }
    }

}
