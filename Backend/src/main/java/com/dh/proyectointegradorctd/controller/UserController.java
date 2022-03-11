package com.dh.proyectointegradorctd.controller;

import com.dh.proyectointegradorctd.model.User;
import com.dh.proyectointegradorctd.service.UserService;
import com.dh.proyectointegradorctd.util.AuthenticationResponse;
import com.dh.proyectointegradorctd.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    /* =============================== Atributos ================================= */

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    /* ================== GET ====================*/

    @GetMapping("")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Integer id) {

        User us = userService.findById(id);

        if(us != null){
            return new ResponseEntity(us, HttpStatus.OK);
        }else{
            return new ResponseEntity("This user id doesn't exist, please correct it", HttpStatus.NOT_FOUND);
        }

    }


    /* ================== POST ====================*/

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user){

        ResponseEntity response;

        if(userService.findByEmail(user.getEmail()) != null){
            response = new ResponseEntity("The email already exists, please change it", HttpStatus.CONFLICT);
        } else{
            User us = userService.save(user);
            String token = jwtUtil.createToken(us.getUsername(), user);
            response = new ResponseEntity(token, HttpStatus.CREATED);
        }

        return response;

    }

    @CrossOrigin
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user){

        User us = userService.findByEmail(user.getEmail());

        if(us != null){

            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            }catch (BadCredentialsException e) {
                return new ResponseEntity("Bad credentials", HttpStatus.UNAUTHORIZED);
            }
            final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails, us);


            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }else{
            return new ResponseEntity("This email doesn't exist, please correct it", HttpStatus.NOT_FOUND);
        }
    }

    /* ================== PUT ====================*/

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){

        ResponseEntity response;

        if(userService.findById(user.getId()) != null){
            response = new ResponseEntity(userService.update(user), HttpStatus.OK);
        }else{
            response = new ResponseEntity("User with id:" + user.getId() + " don't exist", HttpStatus.NO_CONTENT);
        }

        return response;
    }

    /* ================== DELETE ====================*/

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.delete(id);
    }

    /* ================== Constructor ====================*/

    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }
}
