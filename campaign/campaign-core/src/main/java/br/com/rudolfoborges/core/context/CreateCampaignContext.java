package br.com.rudolfoborges.core.context;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

/**
 * Created by rudolfoborges on 25/07/17.
 */
public class CreateCampaignContext {

	private final String name;

	private final long favouriteTeam;

	private final LocalDate startedAt;

	private final int days;

	public CreateCampaignContext(String name, long favouriteTeam, LocalDate startedAt, int days) {
		this.name = name;
		this.favouriteTeam = favouriteTeam;
		this.startedAt = startedAt;
		this.days = days;
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

	public int getDays() {
		return days;
	}
}
