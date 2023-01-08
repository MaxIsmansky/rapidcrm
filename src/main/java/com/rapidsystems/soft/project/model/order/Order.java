package com.rapidsystems.soft.project.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

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

    private List<ProductOrderInfo> ordersPlates;

    private int price;


}
