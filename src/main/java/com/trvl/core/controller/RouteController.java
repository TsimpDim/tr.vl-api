package com.trvl.core.controller;

import com.trvl.core.dto.PostRouteDTO;
import com.trvl.core.exception.NotFoundException;
import com.trvl.core.model.Route;
import com.trvl.core.model.User;
import com.trvl.core.repository.RouteRepository;
import com.trvl.core.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class RouteController {
    private RouteService routeService;
    private RouteRepository routeRepository;

    @Autowired
    public RouteController(RouteRepository routeRepository, RouteService routeService) {
        this.routeRepository = routeRepository;
        this.routeService = routeService;
    }

    @PostMapping("routes")
    public void insertRoute(@RequestBody PostRouteDTO route) {
        this.routeService.save(route);
    }

    @GetMapping("routes")
    public List<Route> getAllRoutes(@AuthenticationPrincipal User currentUser) {
        return this.routeRepository.findByUserUuid(currentUser.getUuid());
    }

    @GetMapping("routes/{uuid}")
    public Route getRouteByUuid(@PathVariable("uuid") UUID uuid) {
        return this.routeRepository.findById(uuid).orElseThrow(NotFoundException::new);
    }

    @DeleteMapping("routes/{uuid}")
    public void removePerson(@PathVariable("uuid") UUID uuid){
        this.routeRepository.deleteById(uuid);
    }
}
