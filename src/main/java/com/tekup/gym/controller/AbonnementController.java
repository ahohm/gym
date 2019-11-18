package com.tekup.gym.controller;

import com.tekup.gym.dao.AbonnementDao;
import com.tekup.gym.entity.Abonne;
import com.tekup.gym.entity.Abonnement;
import com.tekup.gym.entity.Category;
import com.tekup.gym.service.AbonneService;
import com.tekup.gym.service.AbonnementService;
import com.tekup.gym.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/abonnement")
public class AbonnementController {

    private AbonnementService abonnementService;
    private AbonneService abonneService;
    private CategoryService categoryService;


  /*  @PostMapping("add")
    public ResponseEntity<Abonnement> addNewAbonnement(@RequestBody Abonnement abonnement){
        try {
            return new ResponseEntity(abonnementService.addNewAbonnement(abonnement),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @PostMapping("/add/{abonneId}/{categoryId}")
    public ResponseEntity<Abonnement> addAbonnement(@RequestBody Abonnement abonnement, @PathVariable int abonneId, @PathVariable int categoryId){
        Optional<Abonne> abonne = abonneService.getOneSubscriberById(abonneId);
        Optional<Category> category = categoryService.getOneCategoryById(categoryId);
        Abonnement abonnement1 = new Abonnement(abonne.get(), category.get(), abonnement.getStartDate(), abonnement.getEndDate());
        return new ResponseEntity(abonnementService.addNewAbonnement(abonnement), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Abonnement> getAll(){
        try {
            return new ResponseEntity(abonnementService.getAllAbonnement(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Abonnement>> findOne(@PathVariable int id){
        try {
            return new ResponseEntity(abonnementService.getOneAbonnementById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable int id){
        try {
            abonnementService.deleteAbonnementById(id);
            return  new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity updateAbonnement(@PathVariable int id, @RequestBody Abonnement abonnement){
        try{
            return new ResponseEntity(abonnementService.updateAbonnement(id, abonnement),HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
