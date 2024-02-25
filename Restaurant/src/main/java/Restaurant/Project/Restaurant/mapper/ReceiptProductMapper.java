package Restaurant.Project.Restaurant.mapper;

import Restaurant.Project.Restaurant.dto.ReceiptProductDto;
import Restaurant.Project.Restaurant.entity.ReceiptProduct;
import Restaurant.Project.Restaurant.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiptProductMapper {
    @Autowired
    private UserMapper userMapper;
    public static ReceiptProduct mapToEntity(ReceiptProductDto receiptProductDto, User user){
        ReceiptProduct receiptProduct = new ReceiptProduct();
        receiptProduct.setProduct(receiptProductDto.getProduct());
        receiptProduct.setReceipt(receiptProduct.getReceipt());
        receiptProduct.setId(receiptProduct.getId());
        return receiptProduct;
    }
    public ReceiptProductDto mapToDto(ReceiptProduct receiptProduct){
        ReceiptProductDto receiptProductDto = new ReceiptProductDto();
        receiptProductDto.setId(receiptProduct.getId());
        receiptProductDto.setProduct(receiptProduct.getProduct());
        receiptProductDto.setReceipt(receiptProduct.getReceipt());
        return receiptProductDto;
    }

}
