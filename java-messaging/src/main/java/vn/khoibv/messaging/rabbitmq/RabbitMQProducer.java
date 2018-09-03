package vn.khoibv.messaging.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import vn.khoibv.messaging.IMessageProducer;
import vn.khoibv.messaging.model.Email;

/**
 * Created by khoibv on 2018/01/30.
 */
@Component
@Slf4j
public class RabbitMQProducer implements IMessageProducer {


    @Value("${app.rabbitmq.queue.name}")
    private String queueName;

    @Value("${app.rabbitmq.topic.exchange}")
    private String topicExchange;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMail(Email email) {

        rabbitTemplate.convertAndSend(topicExchange, queueName, new Email("khoibv@nissho-vn.com", "This is body's message sent by RabbitMQ"));

    }

}
