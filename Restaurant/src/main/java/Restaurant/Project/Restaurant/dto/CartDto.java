package Restaurant.Project.Restaurant.dto;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

public class CartDto {
    private Integer id;
    private Double price;
    private String paymentMethod;
    private UserDto userDto;

    public CartDto() {

    }

    public CartDto(Integer id, Double price, String paymentMethod, UserDto userDto) {
        this.id = id;
        this.price = price;
        this.paymentMethod = paymentMethod;
        this.userDto = userDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public UserDto getUser() {
        return userDto;
    }

    public void setUser(UserDto userDto) {
        this.userDto = userDto;
    }

}
