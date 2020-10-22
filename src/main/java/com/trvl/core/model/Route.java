package com.trvl.core.model;

import com.trvl.core.model.embeddables.RouteData;
import com.trvl.core.model.embeddables.Units;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="route")
public class Route {

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID uuid;
    private String title;
    private String generalLocation;

    @Embedded
    private Units units;

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

    public Units getUnits() {
        return units;
    }

    public RouteData getData() {
        return data;
    }

    @Override
    public String toString() {
        return '[' + this.uuid.toString() + '|' + this.title + ']';
    }
}