package com.rapidsystems.soft.project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "product_plate")
public class ProductPlate extends AbstractObjectPlate{

    private int calories;

    //todo добавить возможность проверять есть ли полученные из объекта поля в суперклассе данного класса
    private Date createdAt = new Date();

    private String name;

    private String description;

}



