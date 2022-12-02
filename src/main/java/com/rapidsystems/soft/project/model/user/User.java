package com.rapidsystems.soft.project.model.user;


import lombok.*;
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
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @MongoId
    private String id;

    private String lastName;


    private String firstName;


    private String middleName;

    //todo добавить валидацию email (только разрешенные домены)
    private String email;

    private Boolean emailConfirmed = false;

    private String password;

    private Date registered = new Date();

    private Date updated = new Date();

    private Boolean enabled = true;

    private String phone;

    private Set<Role> roles;

}
