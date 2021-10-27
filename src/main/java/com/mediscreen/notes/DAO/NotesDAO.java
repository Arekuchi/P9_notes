package com.mediscreen.notes.DAO;

import com.mediscreen.notes.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesDAO extends JpaRepository<Notes, Long> {


    Notes findNotesById(Long id);


}
