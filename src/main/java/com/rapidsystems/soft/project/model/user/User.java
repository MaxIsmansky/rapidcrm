package com.rapidsystems.soft.project.model.user;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Getter
@Builder
@Setter
@Accessors(chain = true)
@Document(collection = "users")
public class User {

    @MongoId
    private String id;

    private String lastName;


    private String firstName;


    private String middleName;

    //todo добавить валидацию email (только разрешенные домены)
    private String email;

    @Builder.Default
    private Boolean emailConfirmed = false;
    private String password;

    @Builder.Default
    private Date registered = new Date();

    @Builder.Default
    private Date updated = new Date();

    @Builder.Default
    private Boolean enabled = true;

    private String phone;


    private Set<Role> roles;

    public User(String id, String lastName, String firstName, String middleName, String email, Boolean emailConfirmed, String password, Date registered, Date updated, Boolean enabled, String phone, Set<Role> roles) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.emailConfirmed = emailConfirmed;
        this.password = password;
        this.registered = registered;
        this.updated = updated;
        this.enabled = enabled;
        this.phone = phone;
        this.roles = roles;
    }

    public User(String id, String lastName, String firstName, String middleName, String email, String password, String phone, Set<Role> roles) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.emailConfirmed = false;
        this.password = password;
        this.registered = new Date();
        this.updated = new Date();
        this.enabled = true;
        this.phone = phone;
        this.roles = roles;
    }

    public User() {
    }
}
