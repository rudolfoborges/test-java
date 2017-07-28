package br.com.rudolfoborges.user.messaging.campaign;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author rudolfoborges
 * @since 7/25/17 9:02 PM
 */
@JsonSerialize
public class Campaign {

	private long id;

	private String name;

	private long favouriteTeam;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startedAt;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate closedAt;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime createdAt;

	public Campaign() {
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

	public long getFavouriteTeam() {
		return favouriteTeam;
	}

	public void setFavouriteTeam(long favouriteTeam) {
		this.favouriteTeam = favouriteTeam;
	}

	public LocalDate getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDate startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDate getClosedAt() {
		return closedAt;
	}

	public void setClosedAt(LocalDate closedAt) {
		this.closedAt = closedAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
