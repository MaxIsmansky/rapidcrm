package com.rapidsystems.soft.project.model.plate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Accessors(chain = true)
@Document(collection = "products")
public class ProductPlate extends AbstractPlate {

    private int calories;

    private String description;

}



