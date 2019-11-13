package pl.sdacademy.finalproject.user;

import org.springframework.stereotype.Service;
import pl.sdacademy.finalproject.exception.EmailExistsException;
import pl.sdacademy.finalproject.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {

        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void saveUser(RegisterForm registerForm) throws EmailExistsException {

        if (emailExist(registerForm.getEmail())) {
            throw new EmailExistsException("There is account with that email address" + registerForm.getEmail());
        }
        userRepository.save(userMapper.fromRegisterFormToUserModel(registerForm));
    }
    private boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
