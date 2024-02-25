package Restaurant.Project.Restaurant.Controller;

import Restaurant.Project.Restaurant.dto.CartDto;
import Restaurant.Project.Restaurant.entity.User;
import Restaurant.Project.Restaurant.service.CartService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*
import org.springframework.security.access.prepost.PreAuthorize;
*/
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("") //vendosim mapping
public class CartController {
    private CartService cartService;

    @PostMapping("/save")
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CartDto> create(@Valid @RequestBody CartDto newCartDto) {
        return new ResponseEntity<>(cartService.save(newCartDto), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
   // @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<CartDto>> findAll() {
        return ResponseEntity.ok(cartService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteById/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public String deleteById(@PathVariable("id") Integer id) {
        cartService.deleteById(id);
        return "Cart with id " + "was successfully deleted";
    }
}
