package Restaurant.Project.Restaurant.dto;

import Restaurant.Project.Restaurant.entity.Waiter;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Service;


@NoArgsConstructor
@NotNull
public class ReceiptDto {
private Integer Id;
private Double price;
private Waiter waiter;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public ReceiptDto(Integer id, Double price, Waiter waiter) {
        Id = id;
        this.price = price;
        this.waiter = waiter;
    }
}
