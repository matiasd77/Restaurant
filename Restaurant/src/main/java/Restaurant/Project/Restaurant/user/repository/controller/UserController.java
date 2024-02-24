package Restaurant.Project.Restaurant.user.repository.controller;

import Restaurant.Project.Restaurant.entity.User;
import Restaurant.Project.Restaurant.user.repository.dto.UserDto;
import Restaurant.Project.Restaurant.user.repository.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    @PostMapping("/save")
    public User create(@Valid @RequestBody UserDto newUser) {
        return userService.save(newUser);
    }
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @PutMapping("/updateById/{id}")
    public  User updateById(@PathVariable("id") Integer id,@Valid @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Integer id){
        userService.deleteUser(id);
        return "User with this id was delete succesfully";
    }
    @GetMapping(value = "/findByEmail/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable("email") String email) {
        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/findbyName/{name}")
    public List<User> findByName(@PathVariable("name")  String name) {
        return userService.findByName(name);
    }
    @GetMapping(value = "/findbyRole/{role}")
    public User findByRole(@PathVariable("role")  String role) {
        return userService.findByRole(role).get();
    }
}
