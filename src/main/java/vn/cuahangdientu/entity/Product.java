package vn.cuahangdientu.entity;


import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_product;

    @Column(name = "name_product", length = 100, nullable = false)
	private String name;
	/* private String imageUrl; */
    @Column(name = "imageProduct", length = 500, nullable = false)
	private String imageProduct;
    @Column(name = "price", nullable = false)
	private Double price;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    // Getters and setters
}