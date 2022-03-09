package lluna.blog.api.service;

//import lluna.blog.api.request.SignUpReq;
import lluna.blog.db.entity.User;
import lluna.blog.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

//    @Transactional
//    public User signup(SignUpReq signUpReq) {
//        User user = User.builder()
//                .email(signUpReq.getEmail())
//                .password(passwordEncoder.encode(signUpReq.getPassword()))
//                .build();
//
//        return userRepository.save(user);
//    }
}
