package com.rapidsystems.soft.project.model.dto.statisticDto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class CountAndSumPriceOrdersTo {

    private Integer sumPrice;
    private Integer countOrders;

}
