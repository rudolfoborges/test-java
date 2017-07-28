package br.com.rudolfoborges.user.messaging.campaign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@FeignClient(name = "campaignClient", url = "${campaign.url}")
public interface CampaignClient {


	@RequestMapping(value = "/v1/campaigns?favouriteTeam={favouriteTeam}}",
			method = RequestMethod.GET)
	ResponseEntity<Page<Campaign>> finaByFavouriteTeam(@RequestParam("favouriteTeam") long favouriteTeam,
													   @RequestParam("page") long page,
													   @RequestParam("size") long size);

}
