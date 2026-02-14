package tn.esprit.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.user.entity.User;
import tn.esprit.user.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String email, String pwd) {
        Optional<User> user = userRepository.findByEmailAndPwd(email, pwd);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }
}
