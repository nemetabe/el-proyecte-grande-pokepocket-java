package com.codecool.backend.repository;

import com.codecool.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Optional<Category> getCategoryById(int id);
}
