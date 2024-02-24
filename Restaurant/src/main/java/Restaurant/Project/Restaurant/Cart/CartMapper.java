package Restaurant.Project.Restaurant.Cart;

import Restaurant.Project.Restaurant.entity.Cart;
import Restaurant.Project.Restaurant.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    @Autowired
    private UserMapper userMapper;
    public static Cart mapToEntity(CartDTO cartDTO , User user) {
        Cart cart = new Cart();
        cart.setId(cartDTO.getId());
        cart.setPrice(cartDTO.getPrice());
        cart.setPaymentMethod(cartDTO.getPaymentMethod());
        cart.setUser(user);
        return cart;
    }

    public CartDTO mapToDto(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setPrice(cart.getPrice());
        cartDTO.setPaymentMethod(cart.getPaymentMethod());
        cartDTO.setUser(userMapper.toDTO(cart.getUser()));
        return cartDTO;
    }
}
