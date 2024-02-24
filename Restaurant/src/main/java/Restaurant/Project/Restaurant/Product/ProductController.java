package Restaurant.Project.Restaurant.Product;

import Restaurant.Project.Restaurant.entity.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/Product")
@CrossOrigin("http://localhost:3000")
public class ProductController {

    public ProductService productService;

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/save")
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto newProductDto, User user) {
        return new ResponseEntity<>(productService.save(newProductDto), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
    public String deleteById(@PathVariable("id") Integer id){
        productService.deleteById(id);
        return "Product with id "  + id +  " was deleted ";
    }
}

