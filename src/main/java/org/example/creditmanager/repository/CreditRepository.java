package org.example.creditmanager.repository;

import org.example.creditmanager.entity.CreditEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CreditRepository extends JpaRepository<CreditEntity, Long> {
    @EntityGraph(value = "CreditEntity.offersAndStatusHistories")
    Optional<CreditEntity> findOneById(Long id);
    List<CreditEntity> findAllByCheckDateBefore(LocalDateTime checkDate);
}
