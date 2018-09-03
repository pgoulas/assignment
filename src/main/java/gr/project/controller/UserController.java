package gr.project.controller;

import gr.project.model.User;
import gr.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public ResponseEntity welcome() {
        return new ResponseEntity<String>("Your welcome", HttpStatus.OK);
    };

    @RequestMapping(value = "/users", method=RequestMethod.GET)
    public ResponseEntity findUsers() {
        return userService.findAll();
    };
//
////    @RequestMapping(value = "/user", method=RequestMethod.GET)
////    public ResponseEntity findUser(@RequestParam("id") Long id, @RequestParam("id") Long id) {
////        return userService.findOne(id);
////    };
////@RequestMapping(method = RequestMethod.GET, value = "/user")
////public String controllerMethod(@RequestParam Map<String, String> customQuery) {
////
////    System.out.println("customQuery = ipAddress " + customQuery.containsKey("ipAddress"));
////    System.out.println("customQuery = gender " + customQuery.containsKey("gender"));
////    System.out.println("customQuery = email " + customQuery.containsKey("email"));
////    System.out.println("customQuery = firstName " + customQuery.containsKey("firstName"));
////    System.out.println("customQuery = lastName " + customQuery.containsKey("lastName"));
////
////    return customQuery.toString();
////}
@RequestMapping(value = "/user", method=RequestMethod.GET)
public ResponseEntity<User> handleEmployeeRequestByDept (@RequestParam(value = "email", required = false) String email,
                                           @RequestParam(value = "ipAddress", required = false) String ipAddress) {
//    return new ResponseEntity<String>("User id" +"not found", HttpStatus.OK);
    return userService.findUser(email, ipAddress);
}

    @RequestMapping(value="/saveUser", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        return userService.save(user);
    };
}
