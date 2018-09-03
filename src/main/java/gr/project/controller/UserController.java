package gr.project.controller;

import gr.project.model.User;
import gr.project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method=RequestMethod.GET)
    public ResponseEntity findUsers() {
        return userService.findAll();
    };

    @RequestMapping(value = "/user", method=RequestMethod.GET)
    public ResponseEntity<User> findUserbyEmail (@RequestParam(value = "email") String email) {
        return userService.findUserByEmail(email);
    }
    @RequestMapping(value = "/user/{ipAddress}", method=RequestMethod.GET)
    public ResponseEntity<User> findUserbyId (@PathVariable String ipAddress) {
        return userService.findUserByIp(ipAddress);
    }

    @RequestMapping(value="/saveUser", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        return userService.save(user);
    };
}
