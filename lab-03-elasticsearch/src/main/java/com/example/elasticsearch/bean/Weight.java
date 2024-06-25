package com.example.elasticsearch.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Weight {

    private int weight;
    private String uom;

}
