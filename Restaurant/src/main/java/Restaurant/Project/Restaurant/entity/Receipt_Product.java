package Restaurant.Project.Restaurant.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "receipt_product")
public class Receipt_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "id_receipt", referencedColumnName = "id")
    private Receipt receipt;

}
