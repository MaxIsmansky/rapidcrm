package com.rapidsystems.soft.project.model.dto.statisticDto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class CountAndSumPriceProductsTo {

    private List<ProductInfoTo> info;

}
