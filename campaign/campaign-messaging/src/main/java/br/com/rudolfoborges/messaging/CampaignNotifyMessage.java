package br.com.rudolfoborges.messaging;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@JsonSerialize
public class CampaignNotifyMessage {

	private final Long id;

	public CampaignNotifyMessage(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
