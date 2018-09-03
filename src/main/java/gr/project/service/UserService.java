package gr.project.service;

import gr.project.model.User;
import gr.project.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <User>findUserByEmail(String email) {
        User user1 = userRepository.findUserByEmail(email);
        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }

    /**
     * Function that returns User object based on the given ip address
     * @param ipAddress
     */
    public ResponseEntity <User>findUserByIp(String ipAddress) {
        User user2 = userRepository.findUserByIp(ipAddress);
        return new ResponseEntity<User>(user2, HttpStatus.OK);
    }

    /**
     * Function that returns  list of users
     */
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
    }

    /**
     * * Function that posts a user object in the storage
     * @param user
     */
    public ResponseEntity save(User user) {
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }
}