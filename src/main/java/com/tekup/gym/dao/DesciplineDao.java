package com.tekup.gym.dao;

import com.tekup.gym.entity.Descipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesciplineDao extends JpaRepository<Descipline, Integer> {
}
