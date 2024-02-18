package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Products")
@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @Column( name = "Id_Product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    @Column(name = "Name")
    private String name;
    @Column(name = "Category")
    private String category;
    @Column(name = "Price")
    private Double price;

}
