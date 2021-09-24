package com.mediscreen.notes.service;

import com.mediscreen.notes.DAO.NotesDAO;
import com.mediscreen.notes.model.Notes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesDAO notesDAO;


    @Override
    public List<Notes> findAllNotes() {
        return null;
    }

    @Override
    public Notes findNotesById(Long id) {
        return null;
    }

    @Override
    public Notes saveNotes(Notes notes) {
        return null;
    }

    @Override
    public Boolean deleteNotes(Notes notes) {
        return null;
    }

    @Override
    public Notes updateNotes(Long id, Notes notes) {
        return null;
    }
}
