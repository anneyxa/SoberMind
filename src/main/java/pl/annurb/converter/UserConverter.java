package pl.annurb.converter;

import org.springframework.core.convert.converter.Converter;
import pl.annurb.entity.User;
import pl.annurb.repository.UserRepository;

public class UserConverter implements Converter<String, User> {

    private final UserRepository userRepository;

    public UserConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User convert(String id) {
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
