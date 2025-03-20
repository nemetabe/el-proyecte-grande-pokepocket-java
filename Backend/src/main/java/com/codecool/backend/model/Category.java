package com.codecool.backend.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Data
public class Category {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryType type;

    private String description;

    public Category() {
    }
    public Category(CategoryType type) {
        this.type = type;
    }

    public Category(CategoryType type, String description) {
        this.type = type;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && type == category.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

    // Keep the category types as an enum
    public enum CategoryType {
        INCOME,
        GROCERY,
        HOUSEHOLD_SUPPLIES,
        BILLS,
        CLOTHING,
        PETS,
        INSURANCE,
        SAVINGS,
        RENT,
        UTILITIES,
        DINING_OUT,
        TRANSPORTATION,
        ENTERTAINMENT,
        HEALTH_CARE,
        EDUCATION,
        PERSONAL_CARE,
        MISCELLANEOUS,
        LOAN,
        PAYMENTS,
        FEES,
        OTHER
    }
}
