package Restaurant.Project.Restaurant.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "receipt_product")
public class ReceiptProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "id_receipt", referencedColumnName = "id")
    private Receipt receipt;

    public ReceiptProduct(){
        
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public ReceiptProduct(Integer id, Product product, Receipt receipt) {
        this.id = id;
        this.product = product;
        this.receipt = receipt;
    }
}
