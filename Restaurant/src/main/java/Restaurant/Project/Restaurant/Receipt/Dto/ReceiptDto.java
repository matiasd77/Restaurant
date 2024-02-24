package Restaurant.Project.Restaurant.Receipt.Dto;

import Restaurant.Project.Restaurant.entity.Waiter;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull
public class ReceiptDto {
    private Integer Id;
    private Double price;
    private WaiterDTO waiter;
}
