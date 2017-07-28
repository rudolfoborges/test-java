package br.com.rudolfoborges.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import br.com.rudolfoborges.user.core.User;
import br.com.rudolfoborges.user.core.context.CreateUserContext;
import br.com.rudolfoborges.user.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@Api(value = "API para gerenciamento de usuários")
@RestController
@RequestMapping(value = "v1/users",
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation("Cadastro de Usuário")
	@PostMapping
	public ResponseEntity<User> post(@RequestBody @Valid CreateUserContext context){
		final User user = userService.create(context);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(user);
	}

}
