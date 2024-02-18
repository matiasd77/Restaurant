package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReceipt;
    @Column(name = "Total_Price")
    private Double totalPrice;
    @OneToMany
    List<Receipt_Product> receiptProductList ;
    @OneToOne
    private Waiters waiters;
}
