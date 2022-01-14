package com.example.exam_prep_shopping_list_app.repositories;

import com.example.exam_prep_shopping_list_app.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
