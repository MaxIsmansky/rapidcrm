package com.rapidsystems.soft.project.model.order;

import com.rapidsystems.soft.project.model.plate.ProductPlate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    @MongoId
    private String id;

    private String userId;

    private Date createdDate = new Date();

    private Date startInProgressDate;

    private Date completeDate;

    private Map<String, Integer> ordersPlates;

    private int price;


}
