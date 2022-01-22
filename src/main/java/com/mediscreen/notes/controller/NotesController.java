package com.mediscreen.notes.controller;

import com.mediscreen.notes.DAO.NotesDAO;
import com.mediscreen.notes.model.Notes;
import com.mediscreen.notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost/")
@RestController
public class NotesController {

    @Autowired
    private NotesService notesService;

    @Autowired
    private NotesDAO notesDao;

    // GET

    /**
     * Méthode pour renvoyer la liste complète des Notes en base de donnée.
     * @return
     */
    @GetMapping(value = "/notesList")
    public List<Notes> findAllNotes() {
        List<Notes> notesList = notesService.findAllNotes();

        return notesList;
    }

    /**
     * Méthode pour renvoyer une seule Notes en la cherchant depuis son ID
     * @param id
     * @return
     */
    @GetMapping(value = "notesById/{id}")
    public Notes findNotesById(@PathVariable("id") String id) {
        Notes note = notesService.findNotesById(id);

        return note;
    }

    /**
     * Méthode pour renvoyer la liste de toutes les Notes appartenant à un Patient depuis l'ID de ce dernier
     * @param id
     * @return
     */
    @GetMapping(value = "notesByPatientId/{id}")
    public List<Notes> findNotesByPatientId(@PathVariable("id") Long id) {

        List<Notes> notesListByPatientId = notesService.findNotesByPatientId(id);

        return notesListByPatientId;
    }

    // POST

    /**
     * Méthode pour enregistrer une Notes en base de donnée
     * @param notes
     * @return
     */
    @PostMapping(value = "/notesSave", produces = MediaType.APPLICATION_JSON_VALUE)
    public Notes notesSave(@RequestBody Notes notes) {
        notesService.saveNotes(notes);
        Notes newNotes = notesService.findNotesById(notes.getId());

        return newNotes;
    }

    // DELETE

    /**
     * Méthode pour supprimer une Notes de la base de donnée
     * @param id
     * @return
     */
    @DeleteMapping(value = "/notesDelete/{id}")
    public Boolean notesDelete(@PathVariable(value = "id") String id) {

        Notes note = notesService.findNotesById(id);


        if (Objects.isNull(note)) {
            System.out.println("note vide");
        } else {
            System.out.println("suppression de la note");
            notesDao.deleteNotesById(note.getId());
        }



        return true;
    }

    // UPDATE

    /**
     * Méthode pour mettre à jour une Notes
     * @param id
     * @param notes
     * @return
     */
    @PutMapping(value = "/notesUpdate/{id}")
    public Notes notesUpdate(@PathVariable(value = "id") String id, @RequestBody Notes notes) {

        Notes notesToUpdate = notesDao.findNotesById(id);
        notesToUpdate.setNotes(notes.getNotes());


        return notesDao.save(notesToUpdate);
    }


}
