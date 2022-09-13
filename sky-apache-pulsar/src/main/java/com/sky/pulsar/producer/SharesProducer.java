package com.sky.pulsar.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SharesProducer {

    /** Pulsar client **/
    @Autowired
    private PulsarClient pulsarClient;

    @Value("${producerTopic}")
    private String producerTopic;

    public void processEvent() throws Exception {
        log.info("Pulsar Producer : Producing Event");
        Producer<Object> producer = pulsarClient.newProducer(Schema.JSON(Object.class))
                .topic(producerTopic).create();
    }
}
