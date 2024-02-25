package Restaurant.Project.Restaurant.service;

import Restaurant.Project.Restaurant.Repository.ProductRepository;
import Restaurant.Project.Restaurant.dto.ProductDto;
import Restaurant.Project.Restaurant.entity.Product;
import Restaurant.Project.Restaurant.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class ProductService {

    private ProductRepository productRepository;

    private ProductMapper productMapper;

    public ProductDto save(ProductDto newProductDto) {
        Product product = productMapper.mapToEntity(newProductDto);
        Product savedProduct = productRepository.save(product);

        return productMapper.mapToDto(savedProduct);
    }

    public List<ProductDto> findAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDto = new ArrayList<>();
        for (Product product : productList) {
            productDto.add(productMapper.mapToDto(product));
        }
        return productDto;
    }

    public ProductDto findById(Integer id) {
        Product foundProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id:" + id + "was not found!"));
        ProductDto bookDto = productMapper.mapToDto(foundProduct);

        return productMapper.mapToDto(foundProduct);
    }

    public ProductDto updateById(Integer id, ProductDto updatedProductToDto) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (!existingProduct.isPresent()) {
            throw new RuntimeException("Product with id: " + id + "was not found");
        }
        existingProduct.get().setName(updatedProductToDto.getName());
        existingProduct.get().setCategory(updatedProductToDto.getCategory());
        existingProduct.get().setPrice(updatedProductToDto.getPrice());
        existingProduct.get().setId(id);

        Product savedProduct = productRepository.save(existingProduct.get());
        return productMapper.mapToDto(savedProduct);

    }
    public void deleteById(Integer id){
        Product foundProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id:" + id + "was not found!"));
        productRepository.delete(foundProduct);
    }
}