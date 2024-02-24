package Restaurant.Project.Restaurant.service;

import Restaurant.Project.Restaurant.dto.CartDto;
import Restaurant.Project.Restaurant.dto.WaiterDTO;
import Restaurant.Project.Restaurant.entity.Cart;
import Restaurant.Project.Restaurant.mapper.WaiterMapper;
import Restaurant.Project.Restaurant.Repository.WaiterRepository;
import Restaurant.Project.Restaurant.entity.Waiter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service

public class WaiterService {
    private WaiterRepository waiterRepository;
    private WaiterMapper waiterMapper;


    public WaiterDTO save(WaiterDTO waiterDTO) {
        return waiterMapper
                .mapToDTO(waiterRepository.save(waiterMapper.mapToEntity(waiterDTO)));
    }

    public List<WaiterDTO> findAll() {
        List<Waiter> waiterList = waiterRepository.findAll();
        List<WaiterDTO> waiterDtoList = new ArrayList<>();
        for (Waiter waiter : waiterList) {
            waiterDtoList.add(waiterMapper.mapToDTO(waiter));
        }
        return waiterDtoList;
    }


    public Waiter findById(int id) {
        Waiter foundWaiter = waiterRepository.findById(id).orElseThrow(() -> new RuntimeException("Waiter with id: " + id + "was not found!"));
        return foundWaiter;

    }

    public Waiter updateById(int id, Waiter updatedWaiter) {
        Waiter foundWaiter = waiterRepository.findById(id).orElseThrow(() -> new RuntimeException("Waiter with id:" + id + "was not found!"));
        foundWaiter.setName(updatedWaiter.getName());
        foundWaiter.setSurname(updatedWaiter.getSurname());
        foundWaiter.setId(updatedWaiter.getId());
        foundWaiter.setFeedback(updatedWaiter.getFeedback());

        Waiter savedWaiter = waiterRepository.save(foundWaiter);
        return savedWaiter;
    }

    public void deleteById(int id) {
        Waiter foundWaiter = waiterRepository.findById(id).orElseThrow(() -> new RuntimeException("Waiter with id: " + id + " was not found!"));
        waiterRepository.delete(foundWaiter);

    }

    public List<Waiter> getByName(String name) {
        return waiterRepository.findByName(name);
    }

}
