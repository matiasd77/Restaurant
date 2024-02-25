package Restaurant.Project.Restaurant.Controller;

import Restaurant.Project.Restaurant.dto.CartDto;
import Restaurant.Project.Restaurant.dto.ReceiptProductDto;
import Restaurant.Project.Restaurant.entity.ReceiptProduct;
import Restaurant.Project.Restaurant.entity.User;
import Restaurant.Project.Restaurant.service.ReceiptProductService;
import Restaurant.Project.Restaurant.service.ReceiptService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("") //vendosim mapping
public class ReceiptProductController {
    private ReceiptProductService receiptProductService;
    @Autowired
    public ReceiptProductController(ReceiptProductService receiptProductService) {
        this.receiptProductService = receiptProductService;
    }
    @PostMapping("/saveReceiptProduct")
    public ResponseEntity<ReceiptProductDto> create(@Valid @RequestBody ReceiptProductDto newReceiptProductDto, User user){
        return new ResponseEntity<>(receiptProductService.save(newReceiptProductDto,user), HttpStatus.CREATED);
    }
    @GetMapping("/findAllReceiptProduct")
    // @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ReceiptProductDto>> findAll() {
        return ResponseEntity.ok(receiptProductService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteByIdReceiptProduct/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public String deleteById(@PathVariable("id") Integer id) {
        receiptProductService.deleteById(id);
        return "Cart with id " + "was successfully deleted";
    }
}
