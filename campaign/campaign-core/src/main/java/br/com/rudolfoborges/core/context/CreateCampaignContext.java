package br.com.rudolfoborges.core.context;

import java.time.LocalDate;

/**
 * Created by rudolfoborges on 25/07/17.
 */
public class CreateCampaignContext {

    private String name;

    private long favouriteTeam;

    private LocalDate startedAt;

    private int days;

    public CreateCampaignContext() {
    }

    public CreateCampaignContext(String name, long favouriteTeam, LocalDate startedAt, int days) {
        this.name = name;
        this.favouriteTeam = favouriteTeam;
        this.startedAt = startedAt;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public long getFavouriteTeam() {
        return favouriteTeam;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public int getDays() {
        return days;
    }
}
