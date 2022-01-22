package com.mediscreen.notes.service;

import com.mediscreen.notes.DAO.NotesDAO;
import com.mediscreen.notes.model.Notes;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesDAO notesDAO;


    // READ - GET
    /**
     * Méthode pour renvoyer la liste de toutes les Notes présentes en base de donnée
     * @return
     */
    @Override
    public List<Notes> findAllNotes() {
        return notesDAO.findAll();
    }

    /**
     * Méthode pour renvoyer une Note présente en base de donnée en la cherchant par son ID
     * @param id
     * @return
     */
    @Override
    public Notes findNotesById(String id) {

        return notesDAO.findNotesById(id);
    }

    /**
     * Méthode pour renvoyer toutes les Notes présente en base de donnée d'un Patient en la cherchant par l'ID de ce Patient
     * @param id
     * @return
     */
    @Override
    public List<Notes> findNotesByPatientId(Long patientId) {

        return notesDAO.findNotesByPatientId(patientId);
    }

    // CREATE - POST

    /**
     * Méthode pour enregistrer une Note en base de donnée
     * @param notes
     * @return
     */
    @Override
    public Notes saveNotes(Notes notes) {

        int notesId = notesDAO.findAll().size();
        Long max = 0l;
        if (lastNotes != null) {
            max = new Long(lastNotes.getId());
        }
        notes.setId((notesId + 1) +"");

        return notesDAO.save(notes);
    }

    // DELETE - DELETE

    /**
     * Méthode pour supprimer une Note de la base de donnée en la cherchant par son ID
     * @param notes
     * @return
     */
    @Override
    public Boolean deleteNotes(Notes notes) {

        if (notesDAO.existsById(notes.getId())) {

            Notes noteToDelete = notesDAO.findNotesById(notes.getId());
            notesDAO.deleteNotesById(noteToDelete.getId());

            return true;
        }

        return false;
    }

    // UPDATE - PUT

    /**
     * Méthode pour mettre à jour une Notes en base de données en la cherchant avec son ID
     * @param id
     * @param notes
     * @return
     */
    @Override
    public Notes updateNotes(String id, Notes notes) {
        //Mongo gère naturellement l'update via la méthode save lorsque l'ID existe déjà en base de donnée.
        return notesDAO.save(notes);
    }
}
