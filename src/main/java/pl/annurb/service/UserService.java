package pl.annurb.service;
import org.springframework.stereotype.Service;
import pl.annurb.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.annurb.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //haszowanie hasła
    public boolean createUser(User user){
        if(userRepository.hasLogin(user.getLogin())){
            return false;
        }else{
            final String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            return null != userRepository.save(user);
        }
    }

    public List<User> findAllUsers(){
        return  userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public boolean editUser(User user){
        if(null != userRepository.save(user)){
            return true;
        }
        return false;
    }

}
