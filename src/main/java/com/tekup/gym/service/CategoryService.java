package com.tekup.gym.service;

import com.tekup.gym.dao.CategoryDao;
import com.tekup.gym.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CategoryService {

    private CategoryDao categoryDao;

    public Optional<Category> getOneCategoryById(int id){
        return categoryDao.findById(id);
    }

    public List<Category> getAllCategory(){
        return (List<Category>) categoryDao.findAll();
    }

    public void deleteCategoryById(int id) { categoryDao.deleteById(id); }

    public Category addNewCategory(Category category) { return categoryDao.save(category); }

    public  Category updateCategory(int id, Category category){
        return categoryDao.save(category);
    }



}
