package com.bmc.sfgjms.listener;

import com.bmc.sfgjms.config.JmsConfig;
import com.bmc.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.jgroups.util.UUID;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

/**
 * @author Masoumeh Yeganeh
 * @created 23/05/2023
 */
@Component
@RequiredArgsConstructor
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){

        System.out.println("I got a message");

        System.out.println(helloWorldMessage);

    }


    @JmsListener(destination = JmsConfig.MY_SEND_RECEIVE_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) throws JMSException {

        HelloWorldMessage payload = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("world!!")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payload);

    }
}
