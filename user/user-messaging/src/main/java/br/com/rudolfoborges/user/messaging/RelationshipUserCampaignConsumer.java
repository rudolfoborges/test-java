package br.com.rudolfoborges.user.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import br.com.rudolfoborges.user.messaging.campaign.Campaign;
import br.com.rudolfoborges.user.messaging.campaign.CampaignClient;
import br.com.rudolfoborges.user.persistence.UserEntity;
import br.com.rudolfoborges.user.persistence.repository.UserRepository;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@Service
public class RelationshipUserCampaignConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(RelationshipUserCampaignConsumer.class);

	@Autowired
	private CampaignClient campaignClient;

	@Autowired
	private UserRepository userRepository;


	//Tenta 5 vezes e se não tiver sucesso manda a mensagem para a DLQ
	@RabbitListener(queues = {"${rabbit.user.queue}"})
	public void receiveMessage(RelationshipUserCampaignMessage message) {
		final UserEntity userEntity = userRepository.findOne(message.getUserId());

		LOGGER.info("Try create relationship for user={}", userEntity.getId());

		ResponseEntity<Page<Campaign>> response = campaignClient.finaByFavouriteTeam(userEntity.getId(), 1, 100);

		final List<Campaign> campaigns = response.getBody().getContent();

		//TODO: Criar relacionamento no banco

		LOGGER.info("Created relationship for user={}", userEntity.getId());
	}

}
