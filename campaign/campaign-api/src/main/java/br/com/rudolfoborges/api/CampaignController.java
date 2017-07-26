package br.com.rudolfoborges.api;


import br.com.rudolfoborges.core.Campaign;
import br.com.rudolfoborges.core.context.CreateCampaignContext;
import br.com.rudolfoborges.core.context.CreateCampaignContextBuilder;
import br.com.rudolfoborges.core.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author rudolfoborges
 * @since 7/25/17 9:04 PM
 */
@RestController
@RequestMapping(value = "v1/campaigns",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @GetMapping
    public void get(Pageable pageable) {

    }

    @PostMapping
    public ResponseEntity<Campaign> post(@RequestBody @Valid CampaignRequestBody campaignRequestBody) {

        final CreateCampaignContext createCampaignContext = CreateCampaignContextBuilder
                .newBuilder()
                .name(campaignRequestBody.getName())
                .favouriteTeam(campaignRequestBody.getFavouriteTeam())
                .startedAt(campaignRequestBody.getStartedAt())
                .days(campaignRequestBody.getDays())
                .build();

        final Campaign campaign = campaignService.create(createCampaignContext);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(campaign);
    }

    @PutMapping("{id}")
    public void put() {

    }

    @DeleteMapping("{id}")
    public void delete() {

    }

}
