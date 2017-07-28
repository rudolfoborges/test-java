package br.com.rudolfoborges.user.core;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.hibernate.validator.constraints.Email;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@JsonSerialize
public class User {

	private final long id;

	private final String name;

	private final String email;

	private final LocalDate birthday;

	private final long favouritoTeam;

	private final LocalDateTime createdAt;

	public User(long id, String name, String email, LocalDate birthday, long favouritoTeam, LocalDateTime createdAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.favouritoTeam = favouritoTeam;
		this.createdAt = createdAt;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public long getFavouritoTeam() {
		return favouritoTeam;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
