package com.example.exam_prep_andreys.init;

import com.example.exam_prep_andreys.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final CategoryService categoryService;

    public DBInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.initCategories();


    }
}
