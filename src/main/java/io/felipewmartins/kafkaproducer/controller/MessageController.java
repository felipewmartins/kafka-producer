package io.felipewmartins.kafkaproducer.controller;

import static java.time.LocalDate.now;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.felipewmartins.kafkaproducer.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

	private final MessageProducer messageProducer;
	
	@PostMapping
	public void sendMessage(@RequestBody String message) {
		log.info("Sending new message to kafka at: " + now());
		messageProducer.send(message);
	}
}
