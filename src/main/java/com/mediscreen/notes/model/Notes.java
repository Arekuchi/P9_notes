package com.mediscreen.notes.model;

public class Notes {

    // fields

    private String id;
    private Long patientId;
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
}
