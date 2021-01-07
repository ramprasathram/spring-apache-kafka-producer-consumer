package com.example.spring.apache.kafka.producer.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

	@Value("${topic.name}")
	private String topic;

	@Bean
	public NewTopic newTopic() {
		NewTopic newTopic = new NewTopic(topic, 2, (short) 1);
		System.out.println("Topic Created"+newTopic.toString());
		return newTopic;
	}

}
