package Restaurant.Project.Restaurant.service;

import Restaurant.Project.Restaurant.Repository.CartRepository;
import Restaurant.Project.Restaurant.Repository.UserRepository;
import Restaurant.Project.Restaurant.dto.CartDto;
import Restaurant.Project.Restaurant.entity.Cart;
import Restaurant.Project.Restaurant.entity.User;
import Restaurant.Project.Restaurant.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final UserRepository userRepository;

    public CartDto save(CartDto newCartDto) {

        User user = userRepository.findById(newCartDto.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = CartMapper.mapToEntity(newCartDto,user);

        Cart savedCart = cartRepository.save(cart);
        return cartMapper.mapToDto(savedCart);
    }

    public List<CartDto> findAll() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartDto> cartDtoList = new ArrayList<>();
        for (Cart cart : cartList) {
            cartDtoList.add(cartMapper.mapToDto(cart));
        }
        return cartDtoList;
    }

    public CartDto updateById(Integer id, CartDto updateCartDto) {
        Cart cartFound = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart with id " + id + "was not found"));
        cartFound.setId(updateCartDto.getId());
        cartFound.setPrice(updateCartDto.getPrice());
        cartFound.setPaymentMethod(updateCartDto.getPaymentMethod());
        Cart savedCart = cartRepository.save(cartFound);
        return cartMapper.mapToDto(savedCart);
    }

    public void deleteById(Integer id) {
        Cart foundCart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart with id " + id + "was not found!"));
        cartRepository.delete(foundCart);
    }
}
