package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Date 2020/4/16 10:19
 * @Author 86131
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "local_library", type = "book")
public class Library {

    @Id
    private Integer bookId;
    private String bookCode;
    private String bookName;
    private Integer bookPrice;
    private String bookAuthor;
    private String bookDesc;

}
