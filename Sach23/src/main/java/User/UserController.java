package User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    // API để lấy tất cả người dùng
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // API để thêm người dùng mới
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // API để xóa người dùng theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}