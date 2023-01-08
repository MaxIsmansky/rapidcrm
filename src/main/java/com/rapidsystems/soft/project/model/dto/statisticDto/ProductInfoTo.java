package com.rapidsystems.soft.project.model.dto.statisticDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class ProductInfoTo {

    private String product;
    private Integer count;
    private Integer sumPrice;

}
