package com.bmc.sfgjms.sender;

import com.bmc.sfgjms.config.JmsConfig;
import com.bmc.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.jgroups.util.UUID;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Masoumeh Yeganeh
 * @created 23/05/2023
 */
@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){

        System.out.println("I'm sending a message");

        HelloWorldMessage message = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello world")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

        System.out.println("Message sent!");

    }
}
