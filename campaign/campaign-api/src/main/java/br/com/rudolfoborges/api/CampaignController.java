package br.com.rudolfoborges.api;


import br.com.rudolfoborges.core.Campaign;
import br.com.rudolfoborges.core.context.CreateCampaignContext;
import br.com.rudolfoborges.core.context.UpdateCampaignContext;
import br.com.rudolfoborges.core.service.CampaignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@Api(value = "API para gerenciamento de campanhas")
@RestController
@RequestMapping(value = "v1/campaigns",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @ApiOperation("Obter campanhas podendo filtrar por time de coração")
    @GetMapping
    public ResponseEntity<Page<Campaign>> get(@RequestParam(value = "favouritoTeam", required = false) Long favouritoTeam,
                                              Pageable pageable) {
        final Page<Campaign> campaigns = campaignService.find(favouritoTeam, pageable);
        return ResponseEntity.ok(campaigns);
    }

    @ApiOperation("Obter campanha por id")
    @GetMapping("{id}")
    public ResponseEntity<Campaign> getOne(@PathVariable("id") long id) {
        final Campaign campaign = campaignService.findOne(id);
        return ResponseEntity.ok(campaign);
    }

    @ApiOperation("Cadastrar campanha")
    @PostMapping
    public ResponseEntity<Campaign> post(@RequestBody @Valid CreateCampaignContext context) {

        final Campaign campaign = campaignService.create(context);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(campaign);
    }

    @ApiOperation("Alterar campanha")
    @PutMapping("{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long id,
                                    @RequestBody UpdateCampaignContext context) {

        campaignService.updateAndNotify(id, context);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation("Remover campanha")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        campaignService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
