package br.com.rudolfoborges.persistence.repository;

import br.com.rudolfoborges.persistence.CampaignEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author rudolfoborges
 * @since 7/25/17 9:01 PM
 */
@Repository
public interface CampaignRepository extends JpaRepository<CampaignEntity, Long> {

    Optional<CampaignEntity> findOne(long id);

    Page<CampaignEntity> findByFavouriteTeam(long favouriteTeam, Pageable pageable);

    @Query("select count(e) > 0 from CampaignEntity e where e.id = :id")
    boolean exists(@Param("id") long id);


}
