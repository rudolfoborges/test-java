package br.com.rudolfoborges.core.context;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by rudolfoborges on 25/07/17.
 */
public class CreateCampaignContext {

    @NotNull
    private String name;

    @NotNull
    private Long favouriteTeam;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startedAt;

    @NotNull
    @Min(1)
    private Integer days;

    public CreateCampaignContext() {
    }

    public CreateCampaignContext(String name, Long favouriteTeam, LocalDate startedAt, Integer days) {
        this.name = name;
        this.favouriteTeam = favouriteTeam;
        this.startedAt = startedAt;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFavouriteTeam() {
        return favouriteTeam;
    }

    public void setFavouriteTeam(Long favouriteTeam) {
        this.favouriteTeam = favouriteTeam;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
