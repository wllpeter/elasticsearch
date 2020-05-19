package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;


/**
 * @author wll
 * @Description
 * @create 2020-04-16 22:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "search_local_library", type = "person")
public class Person {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    @Field(store = true, index = true, type = FieldType.Date)
    private Date created;}
