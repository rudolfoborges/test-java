package br.com.rudolfoborges.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@Component
public class CampaignUpdateNotifySender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${rabbit.campaign.exchange}")
	private String exchange;

	@Value("${rabbit.campaign.queue}")
	private String routingKey;

	public void sendMessage(CampaignNotifyMessage message) {
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}

}
