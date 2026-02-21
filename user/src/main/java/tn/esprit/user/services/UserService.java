package tn.esprit.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.user.entity.User;
import tn.esprit.user.repository.UserRepository;

import java.util.List;
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

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(updatedUser.getName());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPwd(updatedUser.getPwd());
            existingUser.setNumTel(updatedUser.getNumTel());
            existingUser.setDateNaiss(updatedUser.getDateNaiss());
            existingUser.setRole(updatedUser.getRole());
            existingUser.setInscriptionOk(updatedUser.isInscriptionOk());
            existingUser.setPosterForum(updatedUser.isPosterForum());
            existingUser.setAvatar(updatedUser.getAvatar());
            existingUser.setCIN(updatedUser.getCIN());
            existingUser.setYearsOfExperience(updatedUser.getYearsOfExperience());
            existingUser.setSpecialization(updatedUser.getSpecialization());
            existingUser.setDepartement(updatedUser.getDepartement());
            existingUser.setAdminCIN(updatedUser.getAdminCIN());
            existingUser.setLevel(updatedUser.getLevel());
            existingUser.setXp(updatedUser.getXp());
            existingUser.setStreak(updatedUser.getStreak());
            existingUser.setCoins(updatedUser.getCoins());
            existingUser.setLanguage(updatedUser.getLanguage());
            existingUser.setJoinDate(updatedUser.getJoinDate());
            existingUser.setBio(updatedUser.getBio());
            return userRepository.save(existingUser);
        });
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
