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

//    MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
//    MongoDatabase db = mongo.getDatabase("mediscreen");
//    MongoCollection<Document> collection = db.getCollection("notes");

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

//        Notes lastNotes = notesDAO.findTopByOrderByIdDesc();
        Notes lastNotes = notesDAO.findFirstByOrderByIdDesc();
        int notesId = notesDAO.findAll().size();
        Long max = 0l;
        if (lastNotes != null) {
            max = new Long(lastNotes.getId());
        }
        notes.setId((notesId + 1) +"");



        return notesDAO.save(notes);
    }

    // DELETE - DELETE
    @Override
    public Boolean deleteNotes(Notes notes) {

        if (notesDAO.existsById(notes.getId())) {

            Notes noteToDelete = notesDAO.findNotesById(notes.getId());
            notesDAO.deleteNotesById(noteToDelete.getId());


//            System.out.println(notes);
//            notesDAO.deleteNotesById(notes.getId());
//            db.getCollection("notes").deleteOne(new Document("_id", notes.getId()));
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
