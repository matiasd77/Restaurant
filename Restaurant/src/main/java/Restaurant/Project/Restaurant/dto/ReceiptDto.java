package Restaurant.Project.Restaurant.dto;

import Restaurant.Project.Restaurant.entity.Waiter;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull
public class ReceiptDto {
private Integer Id;
private Double price;
private Waiter waiter;
}
