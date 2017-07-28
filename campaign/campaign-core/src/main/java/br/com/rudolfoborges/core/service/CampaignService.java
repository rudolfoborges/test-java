package br.com.rudolfoborges.core.service;

import br.com.rudolfoborges.core.Campaign;
import br.com.rudolfoborges.core.context.CreateCampaignContext;
import br.com.rudolfoborges.core.context.UpdateCampaignContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author rudolfoborges
 * @since 7/25/17 9:03 PM
 */
public interface CampaignService {

    Campaign create(CreateCampaignContext context);

    void updateAndNotify(long id, UpdateCampaignContext context);

    Page<Campaign> find(Long favouritoTeam, Pageable pageable);

    Campaign findOne(long id);

    void delete(long id);

}
