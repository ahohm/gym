package com.tekup.gym.service;

import com.tekup.gym.dao.AbonnementDao;
import com.tekup.gym.entity.Abonnement;
import com.tekup.gym.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbonnementService {

    private AbonnementDao abonnementDao;

    public Optional<Abonnement> getOneAbonnementById(int id){
        return abonnementDao.findById(id);
    }

    public List<Abonnement> getAllAbonnement(){
        return (List<Abonnement>) abonnementDao.findAll();
    }

    public void deleteAbonnementById(int id) { abonnementDao.deleteById(id); }

    public Abonnement addNewAbonnement(Abonnement abonnement) { return abonnementDao.save(abonnement); }

    public  Abonnement updateAbonnement(int id, Abonnement abonnement){ return abonnementDao.save(abonnement);}
}
