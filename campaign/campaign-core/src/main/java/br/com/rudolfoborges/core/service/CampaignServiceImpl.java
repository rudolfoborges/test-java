package br.com.rudolfoborges.core.service;

import br.com.rudolfoborges.core.Campaign;
import br.com.rudolfoborges.core.context.CreateCampaignContext;
import br.com.rudolfoborges.core.context.UpdateCampaignContext;
import br.com.rudolfoborges.core.converter.CampaignEntityToCampaignConverter;
import br.com.rudolfoborges.persistence.CampaignEntity;
import br.com.rudolfoborges.persistence.CampaignEntityBuilder;
import br.com.rudolfoborges.persistence.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;

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
    public Campaign create(CreateCampaignContext context) {

        Assert.notNull(context, "CreateCampaignContext is required");

        final int days = context.getDays();
        final LocalDate closedAt = context.getStartedAt().plusDays(days);

        final CampaignEntity campaignEntity = CampaignEntityBuilder
                .newBuilder()
                .name(context.getName())
                .favouriteTeam(context.getFavouriteTeam())
                .startedAt(context.getStartedAt())
                .closedAt(closedAt)
                .build();

        campaignRepository.save(campaignEntity);

        return CampaignEntityToCampaignConverter.convertFrom(campaignEntity);
    }

    @Override
    @Transactional
    public void updateAndNotify(long id, UpdateCampaignContext context) {

        final CampaignEntity campaignEntity = campaignRepository.findOne(id)
                .orElseThrow(RuntimeException::new);

        if (context.getName() != null) {
            campaignEntity.setName(context.getName());
        }

        if (context.getActive() != null) {
            campaignEntity.setActive(context.getActive());
        }

        campaignRepository.save(campaignEntity);
    }


}
