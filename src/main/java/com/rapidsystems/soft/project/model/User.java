package com.rapidsystems.soft.project.model;


import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}, name = "users_unique_email_idx")})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    //todo добавить валидацию email (только разрешенные домены)
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    private Date registered = new Date();

    @Column(name = "updated", nullable = false, columnDefinition = "timestamp default now()")
    private Date updated;

    @Column(name = "enabled", nullable = false, columnDefinition = "default TRUE")
    private Boolean enabled;

    @Column(name = "phone")
    private String phone;

//    @Enumerated(value = EnumType.STRING)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
//            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "uk_user_roles")})
//    @Column(name = "role")
//    @ElementCollection(fetch = FetchType.EAGER)
//    @JoinColumn
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<Role> roles;

//    enum Role {
//        ADMIN, USER;
//    }




}
