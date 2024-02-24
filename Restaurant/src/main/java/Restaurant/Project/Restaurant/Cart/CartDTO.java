package Restaurant.Project.Restaurant.Cart;

import Restaurant.Project.Restaurant.entity.User;

public class CartDTO {
    private Integer id;
    private Double price;
    private String paymentMethod;
    private UserDTO userDTO;

    public CartDTO() {

    }

    public CartDTO(Integer id, Double price, String paymentMethod, UserDTO user) {
        this.id = id;
        this.price = price;
        this.paymentMethod = paymentMethod;
        this.userDTO = user;
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

    public UserDTO getUser() {
        return userDTO;
    }

    public void setUser(UserDTO user) {
        this.userDTO = user;
    }

}
