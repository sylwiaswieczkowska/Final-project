package pl.sdacademy.finalproject.user.model;

import lombok.Getter;
import lombok.Setter;
import pl.sdacademy.finalproject.user.model.RoleModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "email")
    private String email;

    @Column(unique = true, name = "username")
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @ManyToMany(mappedBy = "users")
    private Set<RoleModel> roles = new HashSet<>();

    public void addRole(RoleModel role) {
        roles.add(role);
        role.addUser(this);
    }

}
