package com.trvl.core.repository;

import com.trvl.core.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {
}
