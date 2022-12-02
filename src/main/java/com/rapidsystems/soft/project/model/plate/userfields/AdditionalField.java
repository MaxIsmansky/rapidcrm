package com.rapidsystems.soft.project.model.plate.userfields;

import com.rapidsystems.soft.project.model.plate.ProductPlate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Описание поля для фронта
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "additional_fields")
public class AdditionalField {

    private String fieldName;

    private String fieldValue;

}
