package User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Lấy tất cả người dùng
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Thêm người dùng mới
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Xóa người dùng theo ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
