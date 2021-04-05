package com.trvl.core.repository;

import com.trvl.core.model.Route;
import com.trvl.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RouteRepository extends JpaRepository<Route, UUID> {
    List<Route> findByUserUuid(UUID userUuid);
}
