
/*
* This software is the confidential and proprietary information of
* Cargill, ("Confidential Information"). You shall not
* disclose such Confidential Information and shall use it only in
* accordance with the terms of the license agreement you entered into
* with Cargill.
*
* Created by Sapient
*
*/
package com.sky.pulsar.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * The Class ServiceConfig.
 */
@Data
@Configuration
public class EventConfig {

	/** The brokerServiceUrl. */
	@Value("${brokerServiceUrl}")
	private String brokerServiceUrl;
	
	/** The subscription. */
	@Value("${subscription}")
	private String subscription;

	/** The topic. */
	@Value("${topic}")
	private String topic;

/*    @Value("#{${eventtype.topic.map}}")
    Map<String, String> eventTypeTopicMap;*/
	
/*    @Value("${pulsar.azure.clientId}")
    private String clientId;
    
    @Value("${pulsar.azure.clientSecret}")
    private String clientSecret;
    
    @Value("${pulsar.azure.scope}")
    private String scope;
    
    @Value("${pulsar.azure.granttype}")
    private String granttype;
    
    @Value("${pulsar.azure.tokenurl}")
    private String tokenurl;*/

/*    @Value("${pulsar.azure.producer.clientSecret}")
    private String producerClientSecret;

    @Value("${pulsar.azure.producer.scope}")
    private String producerScope;

    @Value("${pulsar.azure.producer.producerClientId}")
    private String producerClientId;*/


}