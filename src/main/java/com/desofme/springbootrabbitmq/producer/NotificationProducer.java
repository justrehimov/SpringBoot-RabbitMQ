package com.desofme.springbootrabbitmq.producer;

import com.desofme.springbootrabbitmq.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;
    @Value("${sr.rabbit.routing}")
    private String routingName;
    @Value("${sr.rabbit.exchange}")
    private String exchangeName;

    public void sendToQueue(Notification notification){
        log.info("Notification sent ID:{}",notification.getId());
        rabbitTemplate.convertAndSend(exchangeName ,routingName ,notification);
    }
}
