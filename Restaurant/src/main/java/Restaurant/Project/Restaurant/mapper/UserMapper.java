package Restaurant.Project.Restaurant.mapper;

import Restaurant.Project.Restaurant.entity.User;
import Restaurant.Project.Restaurant.dto.UserDto;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  public User maptoEntity(UserDto userDto) {
      User user = new User();
      user.setId(userDto.getId());
      user.setName(userDto.getName());
      user.setSurname(userDto.getSurname());
      user.setEmail(userDto.getEmail());
      user.setPassword(userDto.getPassword());
      user.setRole(userDto.getRole());
      return user;
  }
  public UserDto mapToDto(User user) {
      UserDto userDto = new UserDto();
      userDto.setId(user.getId());
      userDto.setName(user.getName());
      userDto.setSurname(user.getSurname());
      userDto.setEmail(user.getEmail());
      userDto.setPassword(user.getPassword());
      userDto.setRole(user.getRole());
      return userDto;
  }
  }

