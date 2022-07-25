package uz.pdp.cinemaapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import uz.pdp.cinemaapplication.entity.enums.Gender;
import uz.pdp.cinemaapplication.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "users")
@PackagePrivate
public class User extends AbsEntity {
    @Column(nullable = false, name = "full_name")
    String fullName;

    @Column(nullable = false, unique = true, length = 50)
    String username;

    String password;

    Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @ManyToMany
    @JoinTable(name = "users_permissions",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id", referencedColumnName = "id"))
    List<Permission> permissions;


    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    List<Role> roles;

}
