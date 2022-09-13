
/*
 * This software is the confidential and proprietary information of
 * Cargill, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Cargill.
 * Created by Sapient
 */
package com.sky.pulsar.config;

import org.apache.pulsar.client.api.PulsarClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Pulsar Config
 */
@Configuration
public class EventClientConfig {

	/**
	 * The EventConfig
	 */
	@Autowired
	private EventConfig serviceConfig;

	/**
	 * load pulsarClient bean
	 * 
	 * @return pulsar client
	 */
	@Bean(name = "pulsarClient")
	PulsarClient instantiatePulsarClient() throws Exception {
		return PulsarClient.builder().serviceUrl(serviceConfig.getBrokerServiceUrl()).build();
	}

}
