package br.com.rudolfoborges.user.core.converter;

import br.com.rudolfoborges.user.core.User;
import br.com.rudolfoborges.user.persistence.UserEntity;

/**
 * Created by rudolfoborges on 28/07/17.
 */
public class UserEntityToUserConverter {

	public static User convertFrom(UserEntity userEntity){
		return new User(userEntity.getId(),
				userEntity.getName(),
				userEntity.getEmail(),
				userEntity.getBirthday(),
				userEntity.getFavouritoTeam(),
				userEntity.getCreatedAt());
	}

}
