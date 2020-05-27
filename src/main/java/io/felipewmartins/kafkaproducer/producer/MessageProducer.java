package io.felipewmartins.kafkaproducer.producer;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(@RequestBody String data) {
		final String randomUUID = UUID.randomUUID().toString();
		kafkaTemplate.send("messageTopic", randomUUID, data);
	}
}
