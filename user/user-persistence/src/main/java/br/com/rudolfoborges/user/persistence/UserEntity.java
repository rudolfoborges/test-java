package br.com.rudolfoborges.user.persistence;

import org.hibernate.validator.constraints.Email;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private String name;

	@NotNull @Email
	private String email;

	@NotNull
	private LocalDate birthday;

	private long favouritoTeam;

	@NotNull
	private LocalDateTime createdAt;

	public UserEntity() {
	}

	@PrePersist
	public void prePersist(){
		createdAt = LocalDateTime.now();
	}

	public UserEntity(String name, String email, LocalDate birthday, long favouritoTeam) {
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.favouritoTeam = favouritoTeam;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getFavouritoTeam() {
		return favouritoTeam;
	}

	public void setFavouritoTeam(long favouritoTeam) {
		this.favouritoTeam = favouritoTeam;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
