package com.mediscreen.notes.model;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Notes {

    // fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "patientID")
    private Long patientId;
    @Column(name = "notes")
    private String notes;


    // constructor

    public Notes() {
    }

    public Notes(Long id, Long patientId, String notes) {
        this.id = id;
        this.patientId = patientId;
        this.notes = notes;
    }

    // getter & setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
