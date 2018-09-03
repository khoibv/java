package vn.khoibv.messaging;

import vn.khoibv.messaging.model.Email;

/**
 * Created by khoibv on 2018/01/30.
 */
public interface IMessageProducer {

    void sendMail(Email email);

}
