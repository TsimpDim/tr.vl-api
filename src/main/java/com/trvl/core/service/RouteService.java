package com.trvl.core.service;

import com.trvl.core.dto.PostRouteDTO;
import com.trvl.core.model.Route;
import com.trvl.core.repository.RouteRepository;
import com.trvl.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RouteService {
    private RouteRepository routeRepository;
    private AuthService authService;
    @Autowired
    public RouteService(
            RouteRepository routeRepository, AuthService authService) {
        this.routeRepository = routeRepository;
        this.authService = authService;
    }

    public void save(PostRouteDTO postRequest) {
        Route newRoute = new Route();
        newRoute.setUser(authService.getCurrentUser());
        newRoute.setData(postRequest.getData());
        newRoute.setGeneralLocation(postRequest.getGeneralLocation());
        newRoute.setTitle(postRequest.getTitle());

        this.routeRepository.save(newRoute);
    }
}
