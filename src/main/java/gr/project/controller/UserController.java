package gr.project.controller;

import gr.project.model.User;
import gr.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method=RequestMethod.GET)
    public ResponseEntity<List<User>>findUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    };

    @RequestMapping(value = "/user", method=RequestMethod.GET)
    public ResponseEntity<User> findbyEmail (@RequestParam(value = "email") String email) {
        return new ResponseEntity<User>(userService.findByEmail(email), HttpStatus.OK);
    }
    @RequestMapping(value = "/user/{ipAddress}", method=RequestMethod.GET)
    public ResponseEntity<User> findbyId (@PathVariable String ipAddress) {
        return new ResponseEntity<User>(userService.findByIp(ipAddress), HttpStatus.OK);
    }

    @RequestMapping(value="/saveUser", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    };
}
