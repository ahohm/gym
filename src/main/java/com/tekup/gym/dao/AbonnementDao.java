package com.tekup.gym.dao;

import com.tekup.gym.entity.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementDao extends JpaRepository<Abonnement, Integer> {
}
