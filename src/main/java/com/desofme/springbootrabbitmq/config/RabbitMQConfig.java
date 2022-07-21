package com.desofme.springbootrabbitmq.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {
    @Value("${sr.rabbit.queue}")
    private String queueName;
    @Value("${sr.rabbit.routing}")
    private String routingName;
    @Value("${sr.rabbit.exchange}")
    private String exchangeName;

    private final RabbitTemplate rabbitTemplate;

    @Bean
    public Queue queue(){
       return new Queue(queueName);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding(final Queue queue, final DirectExchange directExchange){
        return BindingBuilder
                .bind(queue)
                .to(directExchange)
                .with(routingName);
    }
}
