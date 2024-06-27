package com.example.elasticsearch.bean;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.validation.constraints.Past;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "employeeindex")
@ToString
public class Employee {

    @Id
    private long id;

    @Field(type = FieldType.Keyword)
    private String name;

    private Integer age;

    private Boolean resigned;

    private String email;

    private String description;

    private List<String> hobbies;

    private BodySize bodySize;

    private List<PastJob> pastJobs;
}
