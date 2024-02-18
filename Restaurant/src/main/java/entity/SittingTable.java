package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Sitting_Table")
public class SittingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTable;
    @Column(name = "Price")
    private Double price;
    @OneToOne
    private Waiters waiters;
    @OneToMany
    private List<Product> productList;
}
