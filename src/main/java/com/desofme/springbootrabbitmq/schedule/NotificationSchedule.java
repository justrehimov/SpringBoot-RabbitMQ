package com.desofme.springbootrabbitmq.schedule;

import com.desofme.springbootrabbitmq.model.Notification;
import com.desofme.springbootrabbitmq.producer.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.UUID;

@EnableScheduling
@Configuration
@RequiredArgsConstructor
public class NotificationSchedule {


    private final NotificationProducer notificationProducer;

    @Scheduled(fixedDelay = 5000)
    private void sendNotification(){
        Notification notification = new Notification();
        notification.setId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("Notification message from Desofme INC");
        notification.setSeen(false);
        notificationProducer.sendToQueue(notification);
    }

}
