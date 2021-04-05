package com.trvl.core.dto;

import com.trvl.core.model.embeddable.RouteData;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class PostRouteDTO {

    @NotBlank(message = "username required")
    private String title;

    private String generalLocation;

    @NotBlank(message = "data required")
    public RouteData data;

    public String getTitle() {
        return title;
    }

    public String getGeneralLocation() {
        return generalLocation;
    }

    public RouteData getData() {
        return data;
    }
}