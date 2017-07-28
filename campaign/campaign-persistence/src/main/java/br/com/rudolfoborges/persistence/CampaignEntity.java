package br.com.rudolfoborges.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author rudolfoborges
 * @since 7/25/17 9:01 PM
 */
@Entity
@Table(name = "campaigns")
public class CampaignEntity {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @NotNull
    private long favouriteTeam;

    @NotNull
    private LocalDate startedAt;

    @NotNull
    private LocalDate closedAt;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private Boolean active;

    public CampaignEntity() {
    }

    public CampaignEntity(String name, long favouriteTeam, LocalDate startedAt, LocalDate closedAt) {
        this.name = name;
        this.favouriteTeam = favouriteTeam;
        this.startedAt = startedAt;
        this.closedAt = closedAt;
    }

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        setActive(true);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFavouriteTeam() {
        return favouriteTeam;
    }

    public void setFavouriteTeam(long favouriteTeam) {
        this.favouriteTeam = favouriteTeam;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDate getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDate closedAt) {
        this.closedAt = closedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
