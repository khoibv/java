package vn.khoibv.messaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class MessagingApplication {

  public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication
        .run(MessagingApplication.class, args);
//
//      JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
//      System.out.println("Start sending email");
//
//      for (int i = 1; i <= 50; i++) {
//
//        String message = String.format("This is sample email's body %03d", i);
//        System.out.println("Sent email " + message);
//        jmsTemplate.convertAndSend("mailbox",
//            new Email("khoibv@nissho-vn.com", message));
//      }
  }
}
