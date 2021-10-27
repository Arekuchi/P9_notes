package com.mediscreen.notes.service;

import com.mediscreen.notes.DAO.NotesDAO;
import com.mediscreen.notes.model.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesDAO notesDAO;

    // READ - GET
    @Override
    public List<Notes> findAllNotes() {
        return notesDAO.findAll();
    }

    @Override
    public Notes findNotesById(Long id) {

        return notesDAO.findNotesById(id);
    }

    // CREATE - POST
    @Override
    public Notes saveNotes(Notes notes) {
        return notesDAO.save(notes);
    }

    // DELETE - DELETE
    @Override
    public Boolean deleteNotes(Notes notes) {

        if (notesDAO.existsById(notes.getId())) {
            notesDAO.delete(notes);
            return true;
        }

        return false;
    }

    // UPDATE - PUT
    @Override
    public Notes updateNotes(Notes notes) {
        return notesDAO.save(notes);
    }
}
