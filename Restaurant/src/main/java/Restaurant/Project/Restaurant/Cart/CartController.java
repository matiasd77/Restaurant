package Restaurant.Project.Restaurant.Cart;

import Restaurant.Project.Restaurant.entity.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("") //vendosim mapping
public class CartController {
    private CartService cartService;

    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CartDTO> create(@Valid @RequestBody CartDTO newCartDTO, User user) {
        return new ResponseEntity<>(cartService.save(newCartDTO,user), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<CartDTO>> findAll() {
        return ResponseEntity.ok(cartService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteById(@PathVariable("id") Integer id) {
        cartService.deleteById(id);
        return "Cart with id " + "was successfully deleted";
    }
}
