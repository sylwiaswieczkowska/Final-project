package pl.sdacademy.finalproject.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.finalproject.user.model.RoleModel;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    Optional<RoleModel> findByRoleName(String roleUser);
}
