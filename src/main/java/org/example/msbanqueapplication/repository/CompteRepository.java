package org.example.msbanqueapplication.repository;

import org.example.msbanqueapplication.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
