package lluna.blog.api.controller;


import io.swagger.annotations.Api;
//import lluna.blog.api.request.SignUpReq;
import lluna.blog.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.validation.Valid;

@Api(value = "유저 API", tags = {"User"})
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping("")
    public String hello() {
        return "hello";
    }
//    public ResponseEntity signup(@Valid @RequestBody SignUpReq signUpReq) {
//        userService.signup(signUpReq);
//
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
