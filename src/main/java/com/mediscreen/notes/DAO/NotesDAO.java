package com.mediscreen.notes.DAO;

import com.mediscreen.notes.model.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesDAO extends MongoRepository<Notes, String> {


    Notes findNotesById(@Param("id") String id);
    
    Notes findTopByOrderByIdDesc();

    List<Notes> findNotesByPatientId(Long patientId);

//    Boolean deleteNotesById(Long id);
}
