package com.rapidsystems.soft.project.model.plate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
public abstract class AbstractPlate {

    @MongoId
    private String id;

    private String sectionId;

    private String author;

    private String createdAt;

}
