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
public class OrderProductStatisticTo {
    @JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date id;
    private List<ProductInfoTo> info;
}
