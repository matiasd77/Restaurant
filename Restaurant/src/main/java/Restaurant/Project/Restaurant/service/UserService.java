package Restaurant.Project.Restaurant.service;

import Restaurant.Project.Restaurant.Repository.UserRepository;
import Restaurant.Project.Restaurant.dto.ReceiptDto;
import Restaurant.Project.Restaurant.entity.Receipt;
import Restaurant.Project.Restaurant.entity.User;
import Restaurant.Project.Restaurant.dto.UserDto;
import Restaurant.Project.Restaurant.mapper.UserMapper;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {
 private UserRepository userRepository;
 private UserMapper userMapper;

 public User save(UserDto newUser){
  User user = userMapper.maptoEntity(newUser);
  return userRepository.save(user);
 }

 public User findById(Integer id){
  return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User with id: " +id+ "was not found!"));
 }
  public  User updateUser(Integer id,User updateUser){
  User foundUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User with id: " +id+ "was not found!"));
  foundUser.setName(updateUser.getName());
  foundUser.setSurname(updateUser.getSurname());
  foundUser.setEmail(updateUser.getEmail());
  foundUser.setPassword(updateUser.getPassword());
  foundUser.setRole(updateUser.getRole());
  User savedUser = userRepository.save(foundUser);
  return savedUser;
  }

  public List<UserDto> findAll(){
   List<User> userList = userRepository.findAll();
   List<UserDto> userDtoList = new ArrayList<>();
   for (User user: userList) {
    userDtoList.add(userMapper.mapToDto(user));
   }
   return userDtoList;
  }

  public void deleteUser(Integer id){
    User founduser=userRepository.findById(id).orElseThrow(()->new RuntimeException("User with id: " +id+ "was not delete!"));
    userRepository.delete(founduser);
  }
 public List<User> findByName(String name) {
  return userRepository.findByName(name);
 }

 public Optional<User> findByEmail(String email) {
  return userRepository.findByEmail(email);
 }
 public Optional<User> findByRole(String role) {
  return userRepository.findByRole(role);
 }




}
