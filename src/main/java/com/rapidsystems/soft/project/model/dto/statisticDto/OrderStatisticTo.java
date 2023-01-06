package com.rapidsystems.soft.project.model.dto.statisticDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class OrderStatisticTo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date _id;

    private Integer countOrders;

    private Integer sumPrice;


}
