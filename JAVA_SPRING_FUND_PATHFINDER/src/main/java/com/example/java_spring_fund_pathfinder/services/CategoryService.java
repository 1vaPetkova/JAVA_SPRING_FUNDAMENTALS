package com.example.java_spring_fund_pathfinder.services;

import com.example.java_spring_fund_pathfinder.models.entities.Category;
import com.example.java_spring_fund_pathfinder.models.entities.enums.CategoryNameEnum;

import java.util.Optional;

public interface CategoryService {
  Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
