package com.mediscreen.notes.service;

import com.mediscreen.notes.model.Notes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotesService {

    // CRUD
    // Get - Read
    List<Notes> findAllNotes();
    Notes findNotesById(Long id);
    List<Notes> findNotesByPatientId(Long patientId);



    // CUD - Create / Update / Delete
    Notes saveNotes(Notes notes);
    Boolean deleteNotes(Notes notes);
    Notes updateNotes(Long id, Notes notes);




}
