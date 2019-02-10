package kafka.sample.springKafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import kafka.sample.springKafka.template.KafkaServiceTemplate;

@Service
public class UserService {
	private static final String USER_TOPIC = "user";

	@Autowired
	private KafkaServiceTemplate template;

	public String registerUser(String username) {
		template.send(USER_TOPIC, username);
		return username;
	}
	
	@KafkaListener(topics= {"user"},groupId="1")
	public void onMessage(String message) {
		System.out.println(message);
	}
}
