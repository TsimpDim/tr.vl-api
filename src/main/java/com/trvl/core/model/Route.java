package com.trvl.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trvl.core.model.embeddable.RouteData;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="route")
public class Route {
    public Route(UUID uuid, User user, String title, String generalLocation, RouteData data) {
        this.uuid = uuid;
        this.user = user;
        this.title = title;
        this.generalLocation = generalLocation;
        this.data = data;
    }

    public Route() {
    }

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID uuid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
    private String title;
    private String generalLocation;

    @Embedded
    private RouteData data;

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getGeneralLocation() {
        return generalLocation;
    }

    public RouteData getData() {
        return data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGeneralLocation(String generalLocation) {
        this.generalLocation = generalLocation;
    }

    public void setData(RouteData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return '[' + this.uuid.toString() + '|' + this.title + ']';
    }
}