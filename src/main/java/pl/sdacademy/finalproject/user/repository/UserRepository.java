package pl.sdacademy.finalproject.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.finalproject.user.model.UserModel;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Long> {

    Optional<UserModel> findByEmail(String email);

}
