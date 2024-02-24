package Restaurant.Project.Restaurant.Receipt.Mapper;

import Restaurant.Project.Restaurant.Receipt.Dto.ReceiptDto;
import Restaurant.Project.Restaurant.entity.Receipt;
import org.springframework.stereotype.Component;

@Component
public class ReceiptMapper {
    public Receipt mapToEntity(ReceiptDto receiptDto) {
        Receipt receipt = new Receipt();
        receipt.setId(receiptDto.getId());
        receipt.setPrice(receiptDto.getPrice());
        receipt.setWaiter(receiptDto.getWaiter());
        return receipt;
    }


    public ReceiptDto mapToDto(Receipt receipt){
        ReceiptDto receiptDto= new ReceiptDto();
        receiptDto.setId(receipt.getId());
        receiptDto.setPrice(receipt.getPrice());
        receiptDto.setWaiter(receipt.getWaiter());
        return receiptDto;
    }
}
