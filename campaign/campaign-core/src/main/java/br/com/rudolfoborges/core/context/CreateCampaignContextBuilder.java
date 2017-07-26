package br.com.rudolfoborges.core.context;

import java.time.LocalDate;

public class CreateCampaignContextBuilder {

	private String name;
	private long favouriteTeam;
	private LocalDate startedAt;
	private int days;

	private CreateCampaignContextBuilder(){
	}

	public static CreateCampaignContextBuilder newBuilder(){
		return new CreateCampaignContextBuilder();
	}

	public CreateCampaignContextBuilder name(String name) {
		this.name = name;
		return this;
	}

	public CreateCampaignContextBuilder favouriteTeam(long favouriteTeam) {
		this.favouriteTeam = favouriteTeam;
		return this;
	}

	public CreateCampaignContextBuilder startedAt(LocalDate startedAt) {
		this.startedAt = startedAt;
		return this;
	}

	public CreateCampaignContextBuilder days(int days) {
		this.days = days;
		return this;
	}

	public CreateCampaignContext build() {
		return new CreateCampaignContext(name, favouriteTeam, startedAt, days);
	}
}