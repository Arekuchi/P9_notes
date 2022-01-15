package com.mediscreen.notes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;



@Document(collection = "notes")
public class Notes {

    // fields

//    @Id
//    @Field("_id")
////    @JsonIgnore
//    private String objectId;

    //    @Indexed
    @MongoId
    @Field(name = "_id")
    private String id;


    @Field(name = "patientId")
    private Long patientId;
    @Field(name = "notes")
    private String notes;


    // constructor

    public Notes() {
    }

    public Notes(String id, Long patientId, String notes) {
        this.id = id;
        this.patientId = patientId;
        this.notes = notes;
    }

    // getter & setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

//    public String getObjectId() {
//        return objectId;
//    }

//    public void setObjectId(String objectId) {
//        objectId = objectId;
//    }
}
