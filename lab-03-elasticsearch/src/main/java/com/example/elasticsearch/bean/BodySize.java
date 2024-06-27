package com.example.elasticsearch.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BodySize {

    private Height height;
    private Weight weight;

}
