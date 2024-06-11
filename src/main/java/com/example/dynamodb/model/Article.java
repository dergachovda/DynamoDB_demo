package com.example.dynamodb.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.example.dynamodb.config.LocalDateTimeConverter;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@DynamoDBTable(tableName = "ArticleDemo")
public class Article {
    private String url;
    private String text;
    private String translation;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public Article(String url, String text) {
        this.url = url;
        this.text = text;
    }

    @DynamoDBHashKey
    public String getUrl() {
        return url;
    }

    @DynamoDBAttribute
    public String getText() {
        return text;
    }

    @DynamoDBAttribute
    public String getTranslation() {
        return translation;
    }

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}
