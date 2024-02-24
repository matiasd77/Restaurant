package Restaurant.Project.Restaurant.service;

import Restaurant.Project.Restaurant.dto.ReceiptProductDto;
import Restaurant.Project.Restaurant.mapper.ReceiptProductMapper;
import Restaurant.Project.Restaurant.repository.ReceiptProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReceiptProductService {
    private ReceiptProductRepo receiptProductRepo;
    private ReceiptProductMapper receiptProductMapper;

    public ReceiptProductDto

}
