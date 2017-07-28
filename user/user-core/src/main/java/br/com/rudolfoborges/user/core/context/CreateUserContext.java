package br.com.rudolfoborges.user.core.context;

import org.hibernate.validator.constraints.Email;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

/**
 * Created by rudolfoborges on 28/07/17.
 */
public class CreateUserContext {

	@NotNull
	private String name;

	@NotNull
	@Email
	private String email;

	@NotNull
	private LocalDate birthday;

	@NotNull
	private Long favouritoTeam;

	public CreateUserContext() {
	}

	public CreateUserContext(String name, String email, LocalDate birthday, Long favouritoTeam) {
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.favouritoTeam = favouritoTeam;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Long getFavouritoTeam() {
		return favouritoTeam;
	}

	public void setFavouritoTeam(Long favouritoTeam) {
		this.favouritoTeam = favouritoTeam;
	}
}
