package Restaurant.Project.Restaurant.mapper;

import Restaurant.Project.Restaurant.dto.ProductDto;
import Restaurant.Project.Restaurant.entity.Product;
import org.springframework.stereotype.Component;

@Component

public class ProductMapper {
    public Product mapToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        return product;
    }

    public ProductDto mapToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategory(product.getCategory());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}
