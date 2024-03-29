package Restaurant.Project.Restaurant.dto;

import Restaurant.Project.Restaurant.entity.Product;
import Restaurant.Project.Restaurant.entity.Receipt;

public class ReceiptProductDto {
    private Integer id;
    private Product product;
    private Receipt receipt;
    private  UserDto userDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public ReceiptProductDto(Integer id, Product product, Receipt receipt, UserDto userDto) {
        this.id = id;
        this.product = product;
        this.receipt = receipt;
        this.userDto = userDto;
    }

    public  ReceiptProductDto(){

    }
}
