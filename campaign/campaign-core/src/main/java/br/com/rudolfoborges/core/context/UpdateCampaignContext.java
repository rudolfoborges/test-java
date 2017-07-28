package br.com.rudolfoborges.core.context;

/**
 * @author rudolfoborges
 * @since 7/26/17 1:10 PM
 */
public class UpdateCampaignContext {

    private String name;

    private Boolean active;

    public UpdateCampaignContext() {
    }

    public UpdateCampaignContext(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return active;
    }

}
