package com.example.elasticsearch.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Height {

    private int height;
    private String uom;

}
