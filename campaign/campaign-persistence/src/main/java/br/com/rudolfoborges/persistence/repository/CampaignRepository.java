package br.com.rudolfoborges.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rudolfoborges.persistence.CampaignEntity;

/**
 * @author rudolfoborges
 * @since 7/25/17 9:01 PM
 */
@Repository
public interface CampaignRepository extends JpaRepository<CampaignEntity, Long> {
}
