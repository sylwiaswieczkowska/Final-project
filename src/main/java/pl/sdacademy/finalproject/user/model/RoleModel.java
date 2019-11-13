package pl.sdacademy.finalproject.user.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "role")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToMany
    private Set<UserModel> users;

    public RoleModel(String roleName) {
        this.roleName = roleName;
    }

    public void addUser(UserModel user) {
        if (users == null) {
            users = new HashSet<>();
        }
        users.add(user);
    }
}
