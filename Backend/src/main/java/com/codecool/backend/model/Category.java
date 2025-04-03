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
        description = type.description;
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
        INCOME("Income"),
        GROCERY("Grocery"),
        HOUSEHOLD_SUPPLIES("Household supplies"),
        BILLS("Bills"),
        CLOTHING("Clothing"),
        PETS("Pets"),
        INSURANCE("Insurance"),
        SAVINGS("Savings"),
        RENT("Rent"),
        UTILITIES("Utilities"),
        DINING_OUT("Dining out"),
        TRANSPORTATION("Transportation"),
        ENTERTAINMENT("Entertainment"),
        HEALTH_CARE("Health care"),
        EDUCATION("Education"),
        PERSONAL_CARE("Personal care"),
        MISCELLANEOUS("Miscellaneous"),
        LOAN("Loan"),
        PAYMENTS("Payments"),
        FEES("Fees"),
        OTHER("Other");

        private final String description;

        CategoryType(String description) {
            this.description = description;
        }
    }
}
