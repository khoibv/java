package vn.khoibv.messaging.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import vn.khoibv.messaging.IMessageProducer;
import vn.khoibv.messaging.model.Email;

@RestController
@RequestMapping("messaging")
@Slf4j
public class MessagingController {

  @Autowired
  @Qualifier("activeMQProducer")
  private IMessageProducer activemqProducer;

  @Autowired
  @Qualifier("rabbitMQProducer")
  private IMessageProducer rabbitmqProducer;

  @PostMapping("activemq")
  @ResponseBody
  public String activemqSendMail(@RequestBody Email email) {

    log.debug("Sent mail [{}] with ActiveMQ", email);
    activemqProducer.sendMail(email);

    return "Send mail OK";
  }


  @PostMapping("rabbitmq")
  @ResponseBody
  public String rabbitmqSendMail(@RequestBody Email email) {

    log.debug("Sent mail [{}] with RabbitMQ", email);
    rabbitmqProducer.sendMail(email);

    return "Send mail OK";
  }
}
