package com.sky.pulsar.test;

public class TestConsumer {

    /*public static void main(String[] args) {
        try {
            PulsarClient client = PulsarClient.builder()
                    .serviceUrl("pulsar://localhost:6650")
                    .build();
            Consumer consumer = client.newConsumer()
                    .topic("my-topic")
                    .subscriptionName("my-subscription")
                    .subscribe();
            while (true) {
                Message msg = consumer.receive();
                try {
                    System.out.println("Message received: " + new String(msg.getData()));
                    consumer.acknowledge(msg);
                }
                catch (Exception e) {
                    consumer.negativeAcknowledge(msg);
                }
            }
        }
        catch(PulsarClientException e) {
            e.printStackTrace();
        }
    }*/
}
