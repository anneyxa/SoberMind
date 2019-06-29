package pl.annurb.service;
import org.springframework.stereotype.Service;
import pl.annurb.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.annurb.repository.UserRepository;

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

}
