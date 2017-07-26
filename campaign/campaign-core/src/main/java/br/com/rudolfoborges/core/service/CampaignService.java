package br.com.rudolfoborges.core.service;

import br.com.rudolfoborges.core.Campaign;
import br.com.rudolfoborges.core.context.CreateCampaignContext;

/**
 * @author rudolfoborges
 * @since 7/25/17 9:03 PM
 */
public interface CampaignService {

	Campaign create(CreateCampaignContext createCampaignContext);

}
