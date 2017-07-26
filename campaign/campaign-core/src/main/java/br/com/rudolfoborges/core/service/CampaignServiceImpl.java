package br.com.rudolfoborges.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;

import javax.transaction.Transactional;

import br.com.rudolfoborges.core.Campaign;
import br.com.rudolfoborges.core.context.CreateCampaignContext;
import br.com.rudolfoborges.core.converter.CampaignEntityToCampaignConverter;
import br.com.rudolfoborges.persistence.CampaignEntity;
import br.com.rudolfoborges.persistence.CampaignEntityBuilder;
import br.com.rudolfoborges.persistence.repository.CampaignRepository;

/**
 * @author rudolfoborges
 * @since 7/25/17 9:03 PM
 */
@Service
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;

	@Override
	@Transactional
	public Campaign create(CreateCampaignContext createCampaignContext) {

		Assert.notNull(createCampaignContext, "CreateCampaignContext is required");

		final int days = createCampaignContext.getDays();
		final LocalDate closedAt = createCampaignContext.getStartedAt().plusDays(days);

		final CampaignEntity campaignEntity = CampaignEntityBuilder
				.newBuilder()
				.name(createCampaignContext.getName())
				.favouriteTeam(createCampaignContext.getFavouriteTeam())
				.startedAt(createCampaignContext.getStartedAt())
				.closedAt(closedAt)
				.build();

		campaignRepository.save(campaignEntity);

		return CampaignEntityToCampaignConverter.convertFrom(campaignEntity);
	}

}
