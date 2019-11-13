package pl.sdacademy.finalproject.user;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sdacademy.finalproject.user.model.RoleModel;
import pl.sdacademy.finalproject.user.model.UserModel;
import pl.sdacademy.finalproject.user.repository.RoleRepository;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserMapper(PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }


    public UserModel fromRegisterFormToUserModel(RegisterForm registerForm) {

        String roleName = "ROLE_USER";

        UserModel userModel = new UserModel();
        userModel.setEmail(registerForm.getEmail());
        userModel.setPasswordHash(passwordEncoder.encode(registerForm.getPassword()));
        userModel.setUsername(registerForm.getUsername());
        userModel.addRole(saveRoleModel(roleName));

        return userModel;

    }
    public RegisterForm fromUserModelToRegisterForm(UserModel userModel){
        RegisterForm registerForm = new RegisterForm();
        registerForm.setEmail(userModel.getEmail());
        registerForm.setUsername(userModel.getUsername());
        registerForm.setPassword(userModel.getPasswordHash());

        return registerForm;

    }
    private RoleModel saveRoleModel(String roleName) {
        return roleRepository.findByRoleName(roleName)
                .orElseGet(()->roleRepository.save(new RoleModel(roleName)));
    }
}
