package com.tekup.gym.service;

import com.tekup.gym.dao.AbonneDao;
import com.tekup.gym.entity.Abonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbonneService {

    private AbonneDao abonneDao;

    @Autowired
    public AbonneService(AbonneDao abonneDao) {
        this.abonneDao = abonneDao;
    }

    public List<Abonne> getAllSibscriber(){
        return (List<Abonne>) abonneDao.findAll();
    }

    public Optional<Abonne> getOneSubscriberById(int id){
        return abonneDao.findById(id);
    }

    public void deleteSubscriberById(int id) {
        abonneDao.deleteById(id); }

    public Abonne addNewSubscriber(Abonne abonne) {
        return abonneDao.save(abonne);
    }

    public  Abonne updateSubscriber(int id, Abonne abonne){
        return abonneDao.save(abonne);
    }

    public Abonne findByCin(String cin){
        return abonneDao.findAbonneByCinEquals(cin);
    }
}
