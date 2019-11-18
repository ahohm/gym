package com.tekup.gym.controller;

import com.tekup.gym.entity.Category;
import com.tekup.gym.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Category> getAll(){
        try {
            return new ResponseEntity(categoryService.getAllCategory(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findOne(@PathVariable int id){
        try {
            return new ResponseEntity(categoryService.getOneCategoryById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable int id){
        try {
            categoryService.deleteCategoryById(id);
            return  new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("add")
    public ResponseEntity<Category> addNewSubscriber(@RequestBody Category Category){
        try {
            return new ResponseEntity(categoryService.addNewCategory(Category),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSubscriber(@PathVariable int id, @RequestBody Category Category){
        try{
            return new ResponseEntity(categoryService.updateCategory(id, Category),HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
