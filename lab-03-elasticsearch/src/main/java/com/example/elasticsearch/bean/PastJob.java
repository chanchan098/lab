package com.example.elasticsearch.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PastJob {

    private String title;
    private String company;
    private int[] yWorked;

}
