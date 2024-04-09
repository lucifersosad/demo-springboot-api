package spring.security.demonht.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spring.security.demonht.entity.RoleEntity;
import spring.security.demonht.entity.UserEntity;
import spring.security.demonht.model.*;
import spring.security.demonht.repository.RoleRepository;
import spring.security.demonht.repository.UserRepository;
import spring.security.demonht.service.JwtService;
import spring.security.demonht.service.UserServiceImpl;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

//    @PostMapping("/addNewUser")
//    public String addNewUser(@RequestBody UserInfo userInfo) {
//        return service. addUser(userInfo);
//    }

    @GetMapping("/user/userProfile")
//    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody LoginDTO authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsernameOrEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsernameOrEmail());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @GetMapping("/new")
    public String addItem() {
        return "Have permission to add";
    }


//
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginDto) {
//
//        return new ResponseEntity<>(authorities, HttpStatus.OK);
//    }
//
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDTO signUpDto) {
        UserEntity user = new UserEntity();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        RoleEntity roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestParam("username") String username,
                                               @RequestParam("password") String password) {

//        String username = loginDto.getUsernameOrEmail();
//        String password = loginDto.getPassword();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        System.out.println(authentication);

        if (authentication.isAuthenticated()) {
            UserModel userModel = new UserModel();
            UserEntity userEntity = userRepository.getUserByUsername(username);
            userModel.setId(String.valueOf(userEntity.getId()));
            userModel.setUsername(userEntity.getUsername());
            userModel.setEmail(userEntity.getEmail());
            userModel.setGender(userEntity.getGender());
            userModel.setImages(userEntity.getImages());
            userModel.setFName(userEntity.getFullName());

            String token = jwtService.generateToken(username);
            TokenList tokenList = new TokenList();
            tokenList.setAccessToken(token);

            AuthResponse authResponse = new AuthResponse();
            authResponse.setSuccess(true);
            authResponse.setError(false);
            authResponse.setStatus(HttpStatus.OK.value());
            authResponse.setMessage("Login Success");
            authResponse.setUser(userModel);
            authResponse.setTokenList(tokenList);

            return ResponseEntity.ok(authResponse);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
        }
    }
}
