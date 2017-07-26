package br.com.rudolfoborges.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

/**
 * @author rudolfoborges
 * @since 7/25/17 9:05 PM
 */
public class CampaignRequestBody {

	@NotNull
	private String name;

	@NotNull
	private Long favouriteTeam;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startedAt;

	@NotNull
	private Integer days;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFavouriteTeam() {
		return favouriteTeam;
	}

	public void setFavouriteTeam(Long favouriteTeam) {
		this.favouriteTeam = favouriteTeam;
	}

	public LocalDate getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDate startedAt) {
		this.startedAt = startedAt;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
}
