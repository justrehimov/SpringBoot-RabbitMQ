package com.desofme.springbootrabbitmq.listener;

import com.desofme.springbootrabbitmq.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationListener {

    @RabbitListener(queues = "desofme-queue")
    public void handleNotification(Notification notification){
        log.info("Message has been accepted ID:{}",notification.getId());
        System.out.println(notification);
    }
}
