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

public class User {

    protected String lastName;

    protected String firstName;

    protected String middleName;

    //todo добавить валидацию email (только разрешенные домены)
    protected String email;

    protected Boolean emailConfirmed = false;

    protected Date registered = new Date();

    protected Date updated = new Date();
    protected Boolean enabled = true;

    protected String phone;

    protected Set<Role> roles;

}
