package com.tekup.gym.dao;

import com.tekup.gym.entity.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbonneDao  extends JpaRepository<Abonne, Integer> {

    Abonne findAbonneByCinEquals(String cin);

}
