package vn.khoibv.messaging.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vn.khoibv.messaging.IMessageConsumer;
import vn.khoibv.messaging.model.Email;

/**
 * Created by khoibv on 2018/01/30.
 */
@Component
@Slf4j
public class RabbitMQConsumer implements IMessageConsumer {

    public void receiveMessage(Email message) {
        log.info("Received <" + message + ">");
    }

}
