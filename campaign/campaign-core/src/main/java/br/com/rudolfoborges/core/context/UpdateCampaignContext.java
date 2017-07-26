package br.com.rudolfoborges.core.context;

/**
 * @author rudolfoborges
 * @since 7/26/17 1:10 PM
 */
public class UpdateCampaignContext {

    private long id;

    private String name;

    private Boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
