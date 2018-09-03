package vn.khoibv.messaging.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Value("${app.rabbitmq.queue.name}")
    private String queueName;

    @Value("${app.rabbitmq.topic.exchange}")
    private String topicExchange;

    @Bean(name = "queue")
    public Queue createQueue() {
        return new Queue(queueName, false);
    }

    @Bean("exchange")
    public TopicExchange createExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    public MessageConverter createMessageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();


        return converter;
    }

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate template = new RabbitTemplate();
        template.setMessageConverter(messageConverter);
        template.setConnectionFactory(connectionFactory);

        return template;
    }

    @Bean
    public MessageListenerAdapter createMessageListenerAdapter(RabbitMQConsumer consumer, MessageConverter messageConverter) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(consumer, messageConverter);

        // Default is `handleMessage`
        messageListenerAdapter.setDefaultListenerMethod("receiveMessage");

        return messageListenerAdapter;
    }

    @Bean
    public MessageListenerContainer createMessageListenerContainer(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(listenerAdapter);
        container.setQueueNames(queueName);

        return container;
    }


}
