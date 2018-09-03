package vn.khoibv.messaging.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import vn.khoibv.messaging.IMessageProducer;
import vn.khoibv.messaging.model.Email;

/**
 * Created by khoibv on 2018/01/30.
 */
@Component
public class SQSProducer implements IMessageProducer {


    @Value("${app.aws.sqs.queue.name}")
    private String queueName;

    @Override
    public void sendMail(Email email) {

    }
}
