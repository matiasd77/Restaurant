package Restaurant.Project.Restaurant.Receipt.Controller;

import Restaurant.Project.Restaurant.Receipt.Dto.ReceiptDto;
import Restaurant.Project.Restaurant.Receipt.Service.ReceiptService;
import Restaurant.Project.Restaurant.entity.Receipt;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/receipt")
public class ReceiptController {
    private ReceiptService receiptService;
    @GetMapping("/findAll")
    public List<ReceiptDto> findAll(){
        return receiptService.findAll();
    }

    @GetMapping("/findById/{Id}")
    public ReceiptDto findById(@PathVariable("Id") Integer Id) {
        return ReceiptService.findById(Id);
    }

    @PutMapping("/updateById/{Id}")
    public ReceiptDto updateById(@PathVariable("Id") Integer id,@Valid @RequestBody ReceiptDto ReceiptDto) {
        return receiptService.updateById(id, ReceiptDto);
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        receiptService.deleteById(id);
        return "Receipt  with id: " + " was successfully deleted!";
    }



}
