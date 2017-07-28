package br.com.rudolfoborges.user.messaging;

/**
 * Created by rudolfoborges on 28/07/17.
 */
public class RelationshipUserCampaignMessage {

	private final long userId;

	public RelationshipUserCampaignMessage(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}
}
