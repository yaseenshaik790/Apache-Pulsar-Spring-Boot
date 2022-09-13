package com.sky.pulsar.test;

public class TestProducer {

    /*public static void main( String[] args )
    {
        try {
            PulsarClient client = PulsarClient.builder()
                    .serviceUrl("pulsar://localhost:6650")
                    .build();
            Producer<String> stringProducer = client.newProducer(Schema.STRING)
                    .topic("my-topic")
                    .create();
            stringProducer.send("Hello Aayushi");
            stringProducer.close();
        }
        catch (PulsarClientException e) {
            e.printStackTrace();
        }

    }*/
}
