package com.primavera.kafkaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Scanner;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private String topicName = "ubr";

    public static void main(String[] args) {


        SpringApplication.run(KafkaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
			System.out.print("Enter your Kafka Message ");
			String msg = scanner.next();
			System.out.println("producing message: " + msg + "for topic:" +topicName);
			kafkaTemplate.send(topicName, msg);
        }

    }

}
