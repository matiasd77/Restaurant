package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Cart")
public class Cart {
    @Id
    @Column(name = "Id_Cart")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCart;
    @Column(name = "Products")
    private String products;
    @Column(name = "Cmimi_Total")
    private Double totalPrice;
    @Column(name = "Payment_Method")
    private String paymentMethod;
    @OneToMany //Foreign Key
    private List<Product> productList;
    @OneToOne
    private User user;

}
