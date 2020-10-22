package com.trvl.core.model.embeddables;

import javax.persistence.Embeddable;

@Embeddable
public class RouteData {
    private float distanceTravelled;
    private String timeTravelled;
    private float minimumSpeed;
    private float averageSpeed;
    private float maximumSpeed;

    public float getDistanceTravelled() {
        return distanceTravelled;
    }

    public String getTimeTravelled() {
        return timeTravelled;
    }

    public float getMinimumSpeed() {
        return minimumSpeed;
    }

    public float getAverageSpeed() {
        return averageSpeed;
    }

    public float getMaximumSpeed() {
        return maximumSpeed;
    }
}
