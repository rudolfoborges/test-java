package br.com.rudolfoborges.persistence;

import java.time.LocalDate;

public class CampaignEntityBuilder {
	private String name;
	private long favouriteTeam;
	private LocalDate startedAt;
	private LocalDate closedAt;

	private CampaignEntityBuilder(){}

	public static CampaignEntityBuilder newBuilder(){
		return new CampaignEntityBuilder();
	}

	public CampaignEntityBuilder name(String name) {
		this.name = name;
		return this;
	}

	public CampaignEntityBuilder favouriteTeam(long favouriteTeam) {
		this.favouriteTeam = favouriteTeam;
		return this;
	}

	public CampaignEntityBuilder startedAt(LocalDate startedAt) {
		this.startedAt = startedAt;
		return this;
	}

	public CampaignEntityBuilder closedAt(LocalDate closedAt) {
		this.closedAt = closedAt;
		return this;
	}

	public CampaignEntity build() {
		return new CampaignEntity(name, favouriteTeam, startedAt, closedAt);
	}
}