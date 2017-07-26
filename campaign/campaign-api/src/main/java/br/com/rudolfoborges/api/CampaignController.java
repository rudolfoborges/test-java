package br.com.rudolfoborges.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import br.com.rudolfoborges.core.context.CreateCampaignContext;
import br.com.rudolfoborges.core.context.CreateCampaignContextBuilder;
import br.com.rudolfoborges.core.service.CampaignService;

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
	public void get(){

	}

	@PostMapping
	public ResponseEntity<Void> post(@RequestBody @Valid CampaignRequestBody campaignRequestBody){

		final CreateCampaignContext createCampaignContext = CreateCampaignContextBuilder
				.newBuilder()
				.name(campaignRequestBody.getName())
				.favouriteTeam(campaignRequestBody.getFavouriteTeam())
				.startedAt(campaignRequestBody.getStartedAt())
				.days(campaignRequestBody.getDays())
				.build();

		campaignService.create(createCampaignContext);

		return null;
	}

	@PutMapping
	public void put(){

	}

	@DeleteMapping
	public void delete(){

	}

}
