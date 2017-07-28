package br.com.rudolfoborges.user.core.service;

import br.com.rudolfoborges.user.core.User;
import br.com.rudolfoborges.user.core.context.CreateUserContext;

/**
 * Created by rudolfoborges on 28/07/17.
 */
public interface UserService {

	User create(CreateUserContext context);

}
