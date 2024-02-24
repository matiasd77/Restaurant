package Restaurant.Project.Restaurant.Receipt.Mapper;

import Restaurant.Project.Restaurant.Receipt.Dto.ReceiptDto;
import Restaurant.Project.Restaurant.entity.Receipt;
import Restaurant.Project.Restaurant.entity.Waiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiptMapper {

    @Autowired
    private WaiterMapper waiterMapper;

    public Receipt mapToEntity(ReceiptDto receiptDto, Waiter waiter) {
        Receipt receipt = new Receipt();
        receipt.setId(receiptDto.getId());
        receipt.setPrice(receiptDto.getPrice());
        receipt.setWaiter(waiter);
        return receipt;
    }


    public ReceiptDto mapToDto(Receipt receipt){
        ReceiptDto receiptDto= new ReceiptDto();
        receiptDto.setId(receipt.getId());
        receiptDto.setPrice(receipt.getPrice());
        receiptDto.setWaiter(waiterMapper.toDTO(receipt.getWaiter()));
        return receiptDto;
    }
}
