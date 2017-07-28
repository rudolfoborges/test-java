package br.com.rudolfoborges.user.persistence;

import java.time.LocalDate;

public class UserEntityBuilder {

	private String name;
	private String email;
	private LocalDate birthday;
	private long favouritoTeam;

	private UserEntityBuilder(){
	}

	public  static UserEntityBuilder newBuilder(){
		return new UserEntityBuilder();
	}


	public UserEntityBuilder name(String name) {
		this.name = name;
		return this;
	}

	public UserEntityBuilder email(String email) {
		this.email = email;
		return this;
	}

	public UserEntityBuilder birthday(LocalDate birthday) {
		this.birthday = birthday;
		return this;
	}

	public UserEntityBuilder favouritoTeam(long favouritoTeam) {
		this.favouritoTeam = favouritoTeam;
		return this;
	}

	public UserEntity build() {
		return new UserEntity(name, email, birthday, favouritoTeam);
	}
}