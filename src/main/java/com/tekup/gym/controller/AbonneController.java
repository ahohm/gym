package com.tekup.gym.controller;


import com.tekup.gym.entity.Abonne;
import com.tekup.gym.service.AbonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Subscriber")
public class AbonneController {

    private AbonneService abonneService;

    @Autowired
    public AbonneController(AbonneService abonneService) {
        this.abonneService = abonneService;
    }

    @GetMapping
    public ResponseEntity<Abonne> getAll(){
        try {
            return new ResponseEntity(abonneService.getAllSibscriber(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Abonne>> findOne(@PathVariable int id){
        try {
            return new ResponseEntity(abonneService.getOneSubscriberById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable int id){
        try {
            abonneService.deleteSubscriberById(id);
            return  new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("add")
    public ResponseEntity<Abonne> addNewSubscriber(@RequestBody Abonne abonne){
        try {
            return new ResponseEntity(abonneService.addNewSubscriber(abonne),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSubscriber(@PathVariable int id, @RequestBody Abonne abonne){
        try{
            return new ResponseEntity(abonneService.updateSubscriber(id, abonne),HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByCin/{cin}")
    public ResponseEntity<Abonne> findCin(@PathVariable String cin){
        return new ResponseEntity(abonneService.findByCin(cin), HttpStatus.OK);
    }
}

