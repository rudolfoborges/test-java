package br.com.rudolfoborges.core;

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

	private final long id;

	private final String name;

	private final long favouriteTeam;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private final LocalDate startedAt;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private final LocalDate closedAt;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private final LocalDateTime createdAt;



	public Campaign(long id, String name, long favouriteTeam, LocalDate startedAt, LocalDate closedAt, LocalDateTime createdAt) {
		this.id = id;
		this.name = name;
		this.favouriteTeam = favouriteTeam;
		this.startedAt = startedAt;
		this.closedAt = closedAt;
		this.createdAt = createdAt;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getFavouriteTeam() {
		return favouriteTeam;
	}

	public LocalDate getStartedAt() {
		return startedAt;
	}

	public LocalDate getClosedAt() {
		return closedAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
