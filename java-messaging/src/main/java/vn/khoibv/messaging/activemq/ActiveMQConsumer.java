package vn.khoibv.messaging.activemq;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import vn.khoibv.messaging.IMessageConsumer;
import vn.khoibv.messaging.model.Email;

@Component
@Slf4j
public class ActiveMQConsumer implements IMessageConsumer {

  @PostConstruct
  public void init() {
    log.info("===Start JMS listener====");
  }

  @JmsListener(destination = "mailbox", containerFactory = "mailFactory")
  public void receiveMessage(Email email) {


    log.debug("Received <{}>", email);


  }


  /**
   * Sử dụng 2 consumers để xử lý message
   *
   * @param email
   */
  @JmsListener(destination = "mailbox", containerFactory = "mailFactory")
  public void receiveMessageAndLog(Email email) {
    log.debug("Logging email {}", email);
  }

}
