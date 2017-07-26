package br.com.rudolfoborges.core.converter;

import br.com.rudolfoborges.core.Campaign;
import br.com.rudolfoborges.persistence.CampaignEntity;

/**
 * Created by rudolfoborges on 26/07/17.
 */
public class CampaignEntityToCampaignConverter {

	public static Campaign convertFrom(CampaignEntity campaignEntity){
		return new Campaign(campaignEntity.getId(),
				campaignEntity.getName(),
				campaignEntity.getFavouriteTeam(),
				campaignEntity.getStartedAt(),
				campaignEntity.getClosedAt(),
				campaignEntity.getCreatedAt());
	}

}
