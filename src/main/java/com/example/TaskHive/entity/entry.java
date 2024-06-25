package com.example.TaskHive.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Document(collection = "entries")
@Getter
@Setter
public class entry {

    @Id
    private ObjectId id;

    private String title;

    private String content;

    private LocalDateTime date;


}
