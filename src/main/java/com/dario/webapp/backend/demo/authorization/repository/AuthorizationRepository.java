package com.dario.webapp.backend.demo.authorization.repository;

import com.dario.webapp.backend.demo.authorization.model.Authorization;
import com.dario.webapp.backend.demo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    Optional<Authorization> findByAuthToken(String authToken);

    Authorization findByUser(User user);
}
