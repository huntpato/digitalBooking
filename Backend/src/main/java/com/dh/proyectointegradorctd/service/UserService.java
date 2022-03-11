package com.dh.proyectointegradorctd.service;

import com.dh.proyectointegradorctd.model.User;
import com.dh.proyectointegradorctd.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IEntityService<User>, UserDetailsService {

    /* ======================= Atributos ====================== */

    private final IUserRepository userRepository;

    /* ======================= Métodos ======================== */

    @Override
    public User save(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {

        User tmp = userRepository.findById(user.getId()).orElse(null);

        if(tmp != null){

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            tmp.setNombre(user.getNombre());
            tmp.setApellido(user.getApellido());
            tmp.setEmail(user.getEmail());
            tmp.setPassword(passwordEncoder.encode(user.getPassword()));
            tmp.setUserRole(user.getUserRole());

            return userRepository.save(tmp);
        }else {
            return null;
        }

    }

    @Override
    public String delete(Integer id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return "User with id: " + id + " was deleted";
        }else{
            return "User with id:" + id + " don't exist";
        }
    }

    public User findByEmail(String email){
        return userRepository.findUserByEmail(email).orElse(null);
    }


    public User findUserByData(String nombre, String apellido, String email, String username){
        return userRepository.findUserByNombreAndApellidoAndEmail(nombre, apellido, email).orElse(null);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).orElseThrow((()-> new UsernameNotFoundException("Usuario no encontrado")));
    }

    /* ====================== Constructor =========================== */

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
