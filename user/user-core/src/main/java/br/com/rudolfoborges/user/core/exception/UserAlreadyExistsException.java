package br.com.rudolfoborges.user.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends UserException {

	public UserAlreadyExistsException(){
		super("O e-mail informado já existe");
	}

}
