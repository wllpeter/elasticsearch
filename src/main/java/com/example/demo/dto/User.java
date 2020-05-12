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
 * @create 2020-04-16 23:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "search_my_user", type = "user")
public class User {
    @Id
    @Field(store = true, index = false, type = FieldType.Integer)
    private Integer id;
    @Field(store = true, index = true, type = FieldType.keyword, analyzer = "myanalyzer", searchAnalyzer = "myanalyzer")
    private String username;
    @Field(store = true, index = true, type = FieldType.keyword, analyzer = "myanalyzer", searchAnalyzer = "myanalyzer")
    private String password;
    @Field(store = true, index = true, type = FieldType.Integer, analyzer = "myanalyzer", searchAnalyzer = "myanalyzer")
    private Integer age;
    @Field(store = true, index = true, type = FieldType.keyword, analyzer = "myanalyzer", searchAnalyzer = "myanalyzer")
    private String ip;
    @Field(store = true, index = true, type = FieldType.Date)
    private Date created;

}
