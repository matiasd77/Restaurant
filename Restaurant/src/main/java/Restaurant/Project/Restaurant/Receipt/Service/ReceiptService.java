package Restaurant.Project.Restaurant.Receipt.Service;

import Restaurant.Project.Restaurant.Receipt.Dto.ReceiptDto;
import Restaurant.Project.Restaurant.Receipt.Mapper.ReceiptMapper;
import Restaurant.Project.Restaurant.Receipt.Mapper.WaiterMapper;
import Restaurant.Project.Restaurant.Receipt.Repository.ReceiptRepository;
import Restaurant.Project.Restaurant.Receipt.Repository.WaiterRepository;
import Restaurant.Project.Restaurant.entity.Receipt;
import Restaurant.Project.Restaurant.entity.Waiter;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Service
@NotNull
public class ReceiptService {
    private static ReceiptRepository receiptRepository;
    private static ReceiptMapper receiptMapper;
    private WaiterRepository waiterRepository;
    private WaiterMapper waiterMapper;


    public ReceiptDto save(ReceiptDto newReceiptDto) {

        Waiter findWaiter= waiterRepository.findById(newReceiptDto.getWaiter().getId()).orElseThrow(()-> new RuntimeException("WaiterDto with id: " + newReceiptDto.getWaiter().getId() + " was not found!"));

        Receipt receipt = receiptMapper.mapToEntity(newReceiptDto,findWaiter);
        Receipt saveReceipt = receiptRepository.save(receipt);
        return receiptMapper.mapToDto(saveReceipt);
    }

    public List<ReceiptDto> findAll() {
        List<Receipt> receiptList = receiptRepository.findAll();
        List<ReceiptDto> receiptDtoList = new ArrayList<>();
        for (Receipt receipt : receiptList) {
            receiptDtoList.add(receiptMapper.mapToDto(receipt));
        }
        return receiptDtoList;
    }

      public static ReceiptDto findById(Integer Id){
          Receipt foundReceipt = receiptRepository.findById(Id).orElseThrow(()-> new RuntimeException("ReceiptDto with id: " + Id + " was not found!"));
          return receiptMapper.mapToDto(foundReceipt);
      }

    public ReceiptDto updateById(Integer Id, ReceiptDto updatedReceiptDto){
        Receipt foundReceipt = receiptRepository.findById(Id).orElseThrow(()-> new RuntimeException("Receipt with id: " + Id + " was not found!"));
        Waiter findWaiter = waiterRepository.findById(updatedReceiptDto.getWaiter().getId()).orElseThrow(()-> new RuntimeException("WaiterDto with id: "+ updatedReceiptDto.getWaiter().getId() + " was not found!"));
        foundReceipt.setPrice(updatedReceiptDto.getPrice());
        foundReceipt.setWaiter(findWaiter);
        foundReceipt.setId(updatedReceiptDto.getId());

     Receipt savedReceiptDto = receiptRepository.save(foundReceipt);
     return receiptMapper.mapToDto(savedReceiptDto);
    }


    public void deleteById(Integer Id){
        Receipt foundReceipt = receiptRepository.findById(Id).orElseThrow(()-> new RuntimeException("Receipt with id: " + Id + " was not found!"));
        receiptRepository.delete(foundReceipt);
    }


}
