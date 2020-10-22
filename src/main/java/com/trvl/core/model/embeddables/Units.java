package com.trvl.core.model.embeddables;

import javax.persistence.Embeddable;

@Embeddable
public class Units {
    private String distanceUnit;
    private String speedUnit;

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public String getSpeedUnit() {
        return speedUnit;
    }
}
