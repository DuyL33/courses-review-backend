package com.dlviet.Courses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.lang.annotation.Documented;
import java.util.List;
@Document(collection = "Courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private ObjectId id;
    private int cid;
    private String number;
    private String name;
    private int credit;
    private String description;
    @DocumentReference
    private List<Review> review_ids;
}
