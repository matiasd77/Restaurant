package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Waiters")
public class Waiters {
    @Id
    @Column(name = "Id_Waiter")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idWaiter;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Feedback")
    private Integer feedback;
}
