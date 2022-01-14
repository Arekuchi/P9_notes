package com.mediscreen.notes.service;

import com.mediscreen.notes.DAO.NotesDAO;
import com.mediscreen.notes.model.Notes;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesDAO notesDAO;

    MongoClient mongo = MongoClients.create("mongodb://notesdb:27017");
    MongoDatabase db = mongo.getDatabase("notes");
    MongoCollection<Document> collection = db.getCollection("notes");

    // READ - GET
    @Override
    public List<Notes> findAllNotes() {
        return notesDAO.findAll();
    }

    @Override
    public Notes findNotesById(String id) {

        return notesDAO.findNotesById(id);
    }

    @Override
    public List<Notes> findNotesByPatientId(Long patientId) {

        return notesDAO.findNotesByPatientId(patientId);
    }

    // CREATE - POST
    @Override
    public Notes saveNotes(Notes notes) {

        Notes lastNotes = notesDAO.findTopByOrderByIdDesc();
        Long max = 0l;
        if (lastNotes != null) {
            max = new Long(lastNotes.getId());
        }
        notes.setId((max + 1) +"");



        return notesDAO.save(notes);
    }

    // DELETE - DELETE
    @Override
//    @Query(value="{'id' : $0}", delete = true)
    public Boolean deleteNotes(Notes notes) {

        if (notesDAO.existsById(notes.getId())) {

            db.getCollection("notes").deleteOne(new Document("id", notes.getId()));
//            collection.deleteOne(new Document("_id", notes.getObjectId()));

            return true;
        }

        return false;
    }

    // UPDATE - PUT
    @Override
    public Notes updateNotes(String id, Notes notes) {


        return notesDAO.save(notes);
    }
}
