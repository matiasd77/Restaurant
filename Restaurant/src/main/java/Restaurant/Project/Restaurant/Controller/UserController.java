package Restaurant.Project.Restaurant.Controller;

import Restaurant.Project.Restaurant.entity.User;
import Restaurant.Project.Restaurant.dto.UserDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import Restaurant.Project.Restaurant.service.UserService;
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public User create(@Valid @RequestBody UserDto newUser) {
        return userService.save(newUser);
    }
    @GetMapping("/findAll")
    public List<UserDto> findAll() {
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
    public Optional<User> findByName(@PathVariable("name")  String name) {
        return userService.findByName(name);
    }
    @GetMapping(value = "/findbyRole/{role}")
    public User findByRole(@PathVariable("role")  String role) {
        return userService.findByRole(role).get();
    }
}
