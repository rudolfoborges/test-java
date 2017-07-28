package br.com.rudolfoborges.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.rudolfoborges.messaging.CampaignNotifyMessage;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CampaignNotFoundException extends CampaignException {

	public CampaignNotFoundException(){
		super("A campanha não foi encontrada");
	}

}
