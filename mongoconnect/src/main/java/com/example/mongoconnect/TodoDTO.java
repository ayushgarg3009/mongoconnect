package com.example.mongoconnect;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="todos")
public class TodoDTO {

    @Id
    @Generated
    public int id;

    public String todo;
    public String description;
    public Boolean completed;
    public Date createdAt;
    public Date updatedAt;
}
