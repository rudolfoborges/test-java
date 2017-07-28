package br.com.rudolfoborges.user.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import br.com.rudolfoborges.user.core.User;
import br.com.rudolfoborges.user.core.context.CreateUserContext;
import br.com.rudolfoborges.user.core.converter.UserEntityToUserConverter;
import br.com.rudolfoborges.user.core.exception.UserAlreadyExistsException;
import br.com.rudolfoborges.user.messaging.RelationshipUserCampaignMessage;
import br.com.rudolfoborges.user.messaging.RelationshipUserCampaignSender;
import br.com.rudolfoborges.user.persistence.UserEntity;
import br.com.rudolfoborges.user.persistence.UserEntityBuilder;
import br.com.rudolfoborges.user.persistence.repository.UserRepository;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RelationshipUserCampaignSender relationshipUserCampaignSender;

	@Override
	public User create(CreateUserContext context) {

		if(userRepository.findByEmail(context.getEmail()).isPresent()){
			throw new UserAlreadyExistsException();
		}


		final UserEntity userEntity = UserEntityBuilder
				.newBuilder()
				.name(context.getName())
				.birthday(context.getBirthday())
				.favouritoTeam(context.getFavouritoTeam())
				.email(context.getEmail())
				.build();

		userRepository.save(userEntity);

		final RelationshipUserCampaignMessage message = new RelationshipUserCampaignMessage(userEntity.getId());
		relationshipUserCampaignSender.sendMessage(message);

		return UserEntityToUserConverter.convertFrom(userEntity);
	}


}
