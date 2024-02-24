package Restaurant.Project.Restaurant.Waiter.Mapper;

import Restaurant.Project.Restaurant.Waiter.DTO.WaiterDTO;
import Restaurant.Project.Restaurant.entity.Waiter;
import org.springframework.stereotype.Component;

@Component
public class WaiterMapper {
    public Waiter mapToEntity(WaiterDTO waiterDTO) {
        Waiter waiter = new Waiter();
        waiter.setId(waiterDTO.getId());
        waiter.setName(waiterDTO.getName());
        waiter.setSurname(waiterDTO.getSurname());
        waiter.setFeedback(waiterDTO.getFeedback());
        return waiter;
    }

    public WaiterDTO mapToDTO(Waiter waiter) {
        WaiterDTO waiterDTO = new WaiterDTO();
        waiter.setId(waiter.getId());
        waiter.setName(waiter.getName());
        waiter.setSurname(waiter.getSurname());
        waiter.setFeedback(waiter.getFeedback());
        return waiterDTO;
    }
}
