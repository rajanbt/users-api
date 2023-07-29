package com.lights.products.model.entity;

import com.lights.products.model.Age;
import com.lights.products.model.Division;
import com.lights.products.model.ProductStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "products_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductsEntity {
    @Id
    @GeneratedValue
    // use custom generator to generate the ids based on the given pattern
    @Column(name = "id", nullable = false)
    private Long id;
   @Column(name = "product_code", nullable = false)
    private String productCode;
    @Column(name = "colour", nullable = false)
    private String colour;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "division", nullable = false)
    private Division division;
    @Enumerated(EnumType.STRING)
    @Column(name = "age", nullable = false)
    private Age age;
    @Enumerated(EnumType.STRING)
    @Column(name = "product_status", nullable = false)
    private ProductStatus productStatus;
    @Column(name = "release_date", nullable = false)
    private String releaseDate;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "created", nullable = false)
    @CreationTimestamp
    private Instant created;
    @Column(name = "lastUpdated", nullable = false)
    @UpdateTimestamp
    private Instant lastUpdated;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;



}
