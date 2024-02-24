package Restaurant.Project.Restaurant.Controller;

import Restaurant.Project.Restaurant.dto.ReceiptDto;
import Restaurant.Project.Restaurant.service.ReceiptService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("//updateById/{Id}")
    public ReceiptDto updateById(@PathVariable("Id") Integer id,@Valid @RequestBody ReceiptDto ReceiptDto) {
        return receiptService.updateById(id, ReceiptDto);
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        receiptService.deleteById(id);
        return "Receipt  with id: " + " was successfully deleted!";
    }



}
