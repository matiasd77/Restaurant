package Restaurant.Project.Restaurant.mapper;

import Restaurant.Project.Restaurant.dto.ReceiptProductDto;
import Restaurant.Project.Restaurant.entity.Receipt_Product;
import org.springframework.stereotype.Component;

@Component
public class ReceiptProductMapper {
    public Receipt_Product mapToEntity(ReceiptProductDto receiptProductDto){
        Receipt_Product receipt_product = new Receipt_Product();
        receipt_product.setId(receipt_product.getId());
        receipt_product.setReceipt(receipt_product.getReceipt());
        receipt_product.setProduct(receipt_product.getProduct());
        return receipt_product;

    }
    public ReceiptProductDto mapToDto(Receipt_Product receipt_product){
        ReceiptProductDto receiptProductDto = new ReceiptProductDto();
        receiptProductDto.setId(receipt_product.getId());
        receiptProductDto.setReceipt(receiptProductDto.getReceipt());
        receiptProductDto.setProduct(receiptProductDto.getProduct());
        return receiptProductDto;


    }
}
