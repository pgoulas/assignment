package gr.project.service;

import gr.project.model.User;
//import gr.project.model.Role;
//import gr.project.model.User_Role;
//import gr.project.repository.CategoryRepository;
//import gr.project.repository.RoleRepository;
import gr.project.repository.UserRepository;
//import gr.project.repository.User_RoleRepository;
import lombok.Data;
//import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;


@Service
public class UserService {
    private final UserRepository userRepository;
    Boolean hasEmail;
    Boolean hasIpAddress;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Boolean hasValue(String parameterValue) {
        return parameterValue!= null && !parameterValue.isEmpty();
    }
//    public ResponseEntity<User> findOne(Long id) {
//        return new ResponseEntity<User>(userRepository.findById(id).orElse(null), HttpStatus.OK);
//    }
public ResponseEntity <User>findUser(String email, String ipAddress) {
    User   user1 = userRepository.findUserByEmail(email);
    return new ResponseEntity<User>(user1, HttpStatus.OK);
}
    public ResponseEntity deleteById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found"));
        userRepository.delete(user);
        return new ResponseEntity<String> ("Deleted", HttpStatus.CREATED);

    }
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity save(User user) {
//        userRepository.save(user);
//        <Map<User, Role>> response = roleRepository.findAll();
//        user_role.setRole(aRole);
//        user_role.setUser(user);
//        user_roleRepository.save(user_role);
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }

//    /**
//     * Update User Table
//     * @param id the user id
//     * @param user the user data for the update
//     */
//    public ResponseEntity<User> update(Long id, User user) {
//        return userRepository.findById(id).map(post -> {
//            post.setEmail(user.getEmail());
//            post.setPassword(user.getPassword());
//            post.setEnabled(user.isEnabled());
//            post.setRegisterDate(user.getRegisterDate());
//            return new ResponseEntity<User>(userRepository.save(post), HttpStatus.CREATED);
//        }).orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found"));
//    }

//    public ResponseEntity deleteById(Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found"));
//        userRepository.delete(user);
//        return new ResponseEntity<String> ("Deleted", HttpStatus.CREATED);
//
//    }
}