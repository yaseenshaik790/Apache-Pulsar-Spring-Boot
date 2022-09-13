package com.sky.pulsar.consumer;

import com.sky.pulsar.config.EventConfig;
import com.sky.pulsar.listener.SharesListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@DependsOn("pulsarClient")
public class SharesConsumer {

    /**
     * Service Config
     */
    @Autowired
    private EventConfig serviceConfig;

    /**
     * Pulsar client
     **/
    @Autowired
    @Qualifier("pulsarClient")
    private PulsarClient pulsarClient;

    @Autowired
    private SharesListener sharesListener;

    /**
     * Consume idoc event consumer.
     *
     * @return the consumer
     * @throws IOException the io exception
     */
    @Bean
    public Consumer<byte[]> consumeSharesEvent() throws IOException {
        try {
            log.info("Initalizing Shares Event");
            return pulsarClient.newConsumer()
                    .topic(serviceConfig.getTopic())
                    .subscriptionType(SubscriptionType.Shared)
                    .subscriptionName(serviceConfig.getSubscription())
                    .messageListener(sharesListener)
                    .negativeAckRedeliveryDelay(4 , TimeUnit.DAYS)
                    .subscribe();
        } catch (PulsarClientException exception) {
            log.error("Failed to init consumer");
            return null;
        }
    }

}
