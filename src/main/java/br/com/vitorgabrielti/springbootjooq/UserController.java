package br.com.vitorgabrielti.springbootjooq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("{username}")
    public UserDTO findByUsername(@PathVariable("username") String username){
        return UserMapper.toUserDTO(userRepository.findById(username));
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return UserMapper.toUserDTO(userRepository.create(userDTO));
    }
}
