package com.rapidsystems.soft.project.model.dto.statisticDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderStatisticTo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("date")
    private String _id;

    private Integer completedOrders;


}
