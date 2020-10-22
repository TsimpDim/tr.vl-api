package com.trvl.core.controller;

import com.trvl.core.exception.NotFoundException;
import com.trvl.core.model.Route;
import com.trvl.core.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class RouteController {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteController(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @PostMapping("routes")
    public void insertRoute(@RequestBody Route route) {
        this.routeRepository.save(route);
    }

    @GetMapping("routes")
    public List<Route> getAllRoutes() {
        return this.routeRepository.findAll();
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
