package com.rapidsystems.soft.project.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;




@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}, name = "users_unique_email_idx")})
@Setter
@Getter
@ToString
public class User   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @org.springframework.data.annotation.Id
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    //todo добавить валидацию email (только разрешенные домены)
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
//    @Column(name = "registered")
//    private Date registered = new Date();
//
//    @Column(name = "updated")
//    private Date updated = new Date();

    @Column(name = "enabled")
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


    public User(Long id, String lastName, String firstName, String middleName, String email, String password, Boolean enabled, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.phone = phone;
    }

    public User() {
    }
}
