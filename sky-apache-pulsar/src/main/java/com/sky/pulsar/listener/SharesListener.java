package com.sky.pulsar.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageListener;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.nio.charset.StandardCharsets;

@Slf4j
@DependsOn("pulsarClient")
@Component
public class SharesListener implements MessageListener<byte[]> {

    @Override
    public void received(Consumer<byte[]> consumer, Message<byte[]> message) {
        String response="";
        try {
            log.info("Shares data recieved on consumer");
            response = new String(message.getData(), StandardCharsets.UTF_8);
            log.info("Shares data is :{}",response);
            System.out.println(response);
            log.info("Event Consume Successfully");
            consumer.acknowledge(message);
        }catch (ValidationException ex){
            log.error("Validation Failed due to validation {}", ex.getMessage());
            try {
                consumer.acknowledge(message);

            }catch (PulsarClientException pulsarClientException){
                log.error("Error while acknowledging");
            }
        }
        catch (Exception ex) {
            log.info("Exception while processing Shares data :: {}",ex.getLocalizedMessage());
            consumer.negativeAcknowledge(message);
        }
    }
}
