package Restaurant.Project.Restaurant.Cart;

import Restaurant.Project.Restaurant.entity.Cart;
import Restaurant.Project.Restaurant.entity.User;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private CartRepository cartRepository;
    private CartMapper cartMapper;

    public CartDTO save(CartDTO newCartDTO, User user) {
        Cart cart = CartMapper.mapToEntity(newCartDTO,user);
        Cart savedCart = cartRepository.save(cart);
        return cartMapper.mapToDto(savedCart);
    }

    public List<CartDTO> findAll() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartDTO> cartDTOList = new ArrayList<>();
        for (Cart cart : cartList) {
            cartDTOList.add(cartMapper.mapToDto(cart));
        }
        return cartDTOList;
    }

    public CartDTO updateById(Integer id, CartDTO updateCartDTO) {
        Cart cartFound = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart with id " + id + "was not found"));
        cartFound.setId(updateCartDTO.getId());
        cartFound.setPrice(updateCartDTO.getPrice());
        cartFound.setPaymentMethod(updateCartDTO.getPaymentMethod());
        Cart savedCart = cartRepository.save(cartFound);
        return cartMapper.mapToDto(savedCart);
    }

    public void deleteById(Integer id) {
        Cart foundCart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart with id " + id + "was not found!"));
        cartRepository.delete(foundCart);
    }
}
