package com.rapidsystems.soft.project.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "productInfo")
public class ProductOrderInfo {

    private String productId;

    private int count;

    private int price;
}
