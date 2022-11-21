package com.rapidsystems.soft.project.model;

import lombok.Getter;
import reactor.util.annotation.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractObjectPlate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt = new Date();

    private String name;

    private String description;

}
