package Restaurant.Project.Restaurant.service;

import Restaurant.Project.Restaurant.Repository.ReceiptRepository;
import Restaurant.Project.Restaurant.dto.ReceiptDto;
import Restaurant.Project.Restaurant.mapper.ReceiptMapper;
import Restaurant.Project.Restaurant.entity.Receipt;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@NotNull
public class ReceiptService {
    private static ReceiptRepository receiptRepository;
    private static ReceiptMapper receiptMapper;

    public ReceiptDto save(ReceiptDto newReceiptDto) {
        Receipt receipt = receiptMapper.mapToEntity(newReceiptDto);
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
        foundReceipt.setPrice(updatedReceiptDto.getPrice());
        foundReceipt.setWaiter(updatedReceiptDto.getWaiter());
        foundReceipt.setId(updatedReceiptDto.getId());

     Receipt savedReceiptDto = receiptRepository.save(foundReceipt);
     return receiptMapper.mapToDto(savedReceiptDto);
    }


    public void deleteById(Integer Id){
        Receipt foundReceipt = receiptRepository.findById(Id).orElseThrow(()-> new RuntimeException("Receipt with id: " + Id + " was not found!"));
        receiptRepository.delete(foundReceipt);
    }


}
