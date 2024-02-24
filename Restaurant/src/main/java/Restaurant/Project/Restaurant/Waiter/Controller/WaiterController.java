package Restaurant.Project.Restaurant.Waiter.Controller;

import Restaurant.Project.Restaurant.Waiter.DTO.WaiterDTO;
import Restaurant.Project.Restaurant.Waiter.Service.WaiterService;
import Restaurant.Project.Restaurant.entity.Waiter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/api/waiter")

public class WaiterController {
    private WaiterService waiterService;
    @PostMapping("/save")
    public WaiterDTO create(@RequestBody WaiterDTO newWaiter) {
        return waiterService.save(newWaiter);
    }
    @GetMapping("/findAll")
    public List<Waiter> findAll() {
        return waiterService.findAll();
    }
    @GetMapping("/findById/{id}")
    public Waiter findById(@PathVariable("id") Integer id) {
        return waiterService.findById(id);
    }
    @PutMapping("/updateById/{id}")
    public Waiter updateById(@PathVariable("id") int id, @RequestBody Waiter waiter) {
        return waiterService.updateById(id, waiter);
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id) {
        waiterService.deleteById(id);
            return "Waiter with id: " + " was successfully deleted!";
    }
}
