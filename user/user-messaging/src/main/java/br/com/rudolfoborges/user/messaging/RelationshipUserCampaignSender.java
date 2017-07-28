package br.com.rudolfoborges.user.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@Component
public class RelationshipUserCampaignSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${rabbit.user.exchange}")
	private String exchange;

	@Value("${rabbit.user.queue}")
	private String routingKey;

	public void sendMessage(RelationshipUserCampaignMessage message) {
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}


}
