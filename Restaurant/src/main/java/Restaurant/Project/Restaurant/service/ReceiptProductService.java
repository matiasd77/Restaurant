package Restaurant.Project.Restaurant.service;

import Restaurant.Project.Restaurant.Repository.ReceiptProductRepository;
import Restaurant.Project.Restaurant.dto.ReceiptProductDto;
import Restaurant.Project.Restaurant.entity.ReceiptProduct;
import Restaurant.Project.Restaurant.entity.User;
import Restaurant.Project.Restaurant.mapper.ReceiptProductMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptProductService {
    private ReceiptProductRepository receiptProductRepository;
    private ReceiptProductMapper receiptProductMapper;
    public ReceiptProductDto save(ReceiptProductDto newReceiptProductDto, User user){
        ReceiptProduct receiptProduct = ReceiptProductMapper.mapToEntity(newReceiptProductDto,user);
        ReceiptProduct savedReceiptProduct = receiptProductRepository.save(receiptProduct);
        return receiptProductMapper.mapToDto(savedReceiptProduct);
    }
    public List<ReceiptProductDto> findAll(){
        List<ReceiptProduct> receiptProductList  = receiptProductRepository.findAll();
        List<ReceiptProductDto> receiptProductDtoList = new ArrayList<>();
        for (ReceiptProduct receiptProduct : receiptProductList){
            receiptProductDtoList.add(receiptProductMapper.mapToDto(receiptProduct));
        }
        return receiptProductDtoList;
    }
    public ReceiptProductDto uptadeById(Integer id , ReceiptProductDto updateReceiptProductDto){
        ReceiptProduct foundReceiptProduct = receiptProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receipt product  with id " + id + "was not found"));
        foundReceiptProduct.setProduct(updateReceiptProductDto.getProduct());
        foundReceiptProduct.setReceipt(updateReceiptProductDto.getReceipt());
        foundReceiptProduct.setId(updateReceiptProductDto.getId());
        ReceiptProduct savedReceiptProduct = receiptProductRepository.save(foundReceiptProduct);
        return receiptProductMapper.mapToDto(savedReceiptProduct);
    }
    public void deleteById(Integer id){
        ReceiptProduct receiptProductFound = receiptProductRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product receipt with id " + id + "was not found" ));
        receiptProductRepository.delete(receiptProductFound);
    }

}
