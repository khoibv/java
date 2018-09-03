package vn.khoibv.messaging.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import vn.khoibv.messaging.IMessageProducer;
import vn.khoibv.messaging.model.Email;

/**
 * Created by khoibv on 2018/01/30.
 */
@Component
@Slf4j
public class ActiveMQProducer implements IMessageProducer {


    @Value("${app.activemq.queue.name}")
    private String mailQueue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMail(Email email) {

        jmsTemplate.convertAndSend(mailQueue, email);

    }
}
