package com.example.spring.apache.kafka.producer.consumer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring.apache.kafka.producer.MessageProducer;

@SpringBootApplication(scanBasePackages = "com.example.spring.apache.kafka")
public class SpringKafkaProdConsApp implements CommandLineRunner {

	@Autowired
	private MessageProducer messageProducer;

	private CountDownLatch countDownLatch;

	public static void main(String[] args) {

		SpringApplication.run(SpringKafkaProdConsApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		countDownLatch = new CountDownLatch(1);
		countDownLatch.await(20, TimeUnit.SECONDS);
		messageProducer.produceMessage("Helloworld");
	}

}
