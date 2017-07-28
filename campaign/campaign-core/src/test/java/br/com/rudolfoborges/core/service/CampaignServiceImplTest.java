package br.com.rudolfoborges.core.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;

import br.com.rudolfoborges.core.Campaign;
import br.com.rudolfoborges.core.context.CreateCampaignContext;
import br.com.rudolfoborges.core.context.UpdateCampaignContext;
import br.com.rudolfoborges.core.exception.CampaignNotFoundException;
import br.com.rudolfoborges.messaging.CampaignUpdateNotifySender;
import br.com.rudolfoborges.persistence.CampaignEntity;
import br.com.rudolfoborges.persistence.repository.CampaignRepository;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CampaignServiceImplTest {

	@Mock
	private CampaignRepository campaignRepository;

	@Mock
	private CampaignUpdateNotifySender campaignUpdateNotifySender;

	@InjectMocks
	private CampaignServiceImpl campaignService;


	@Test
	public void shouldCreateCampaign() throws Exception {

		final int days = 10;
		final LocalDate now = LocalDate.now();
		final LocalDate closedAt = now.plusDays(days);

		final CreateCampaignContext context = new CreateCampaignContext("Campanha", 1l, now, days);

		final Campaign campaign = campaignService.create(context);

		assertEquals(closedAt, campaign.getClosedAt());

		verify(campaignRepository, times(1)).save(any(CampaignEntity.class));

	}

	@Test(expected = CampaignNotFoundException.class)
	public void shouldNotUpdateAndNotify() throws Exception {
		when(campaignRepository.findOne(anyLong())).thenReturn(Optional.empty());
		final UpdateCampaignContext context = mock(UpdateCampaignContext.class);

		campaignService.updateAndNotify(anyLong(), context);

		verify(campaignRepository, never()).save(any(CampaignEntity.class));
		verify(campaignUpdateNotifySender, never()).sendMessage(any());
	}

	@Test
	public void shouldUpdateAndNotify() throws Exception {
		final CampaignEntity campaignEntity = mock(CampaignEntity.class);

		when(campaignRepository.findOne(anyLong())).thenReturn(Optional.of(campaignEntity));
		final UpdateCampaignContext context = mock(UpdateCampaignContext.class);

		campaignService.updateAndNotify(anyLong(), context);

		verify(campaignRepository, times(1)).save(any(CampaignEntity.class));
		verify(campaignUpdateNotifySender, times(1)).sendMessage(any());
	}

	@Test
	public void findWithFovouritoTeam() throws Exception {
		final Pageable pageable  = mock(Pageable.class);

		final Page page = mock(Page.class);

		when(campaignRepository.findByFavouriteTeam(1l, pageable)).thenReturn(page);

		campaignService.find(1l, pageable);

		verify(campaignRepository, times(1)).findByFavouriteTeam(anyLong(), any(Pageable.class));

		verify(campaignRepository, never()).findAll(any(Pageable.class));

	}

	@Test
	public void findWithoutFovouritoTeam() throws Exception {
		final Pageable pageable  = mock(Pageable.class);

		final Page page = mock(Page.class);

		when(campaignRepository.findAll(pageable)).thenReturn(page);

		campaignService.find(null, pageable);

		verify(campaignRepository, times(1)).findAll(any(Pageable.class));

		verify(campaignRepository, never()).findByFavouriteTeam(anyLong(), any(Pageable.class));
	}

	@Test(expected = CampaignNotFoundException.class)
	public void shouldNotfindOne() throws Exception {
		when(campaignRepository.findOne(anyLong())).thenReturn(Optional.empty());

		campaignService.findOne(anyLong());
	}

}