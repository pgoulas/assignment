package gr.project.service;

import gr.project.model.User;
import gr.project.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Function that returns User object based on the given email
     * @param email
     */
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Function that returns User object based on the given ip address
     * @param ipAddress
     */
    public User findByIp(String ipAddress) {
       return userRepository.findByIpAddress(ipAddress);
    }

    /**
     * Function that returns  list of users
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * * Function that posts a user object in the storage
     * @param user
     */
    public User save(User user) {
        return userRepository.save(user);
    }
}