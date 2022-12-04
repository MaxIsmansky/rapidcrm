package com.rapidsystems.soft.project.model.plate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rapidsystems.soft.project.model.plate.userfields.AdditionalField;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Document(collection = "products")
public class ProductPlate extends AbstractPlate {

    private int calories;

    private String description;

    private String imageLink;

    private List<AdditionalField> additionalFieldList;

    private Double price;
}



