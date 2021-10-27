package com.mediscreen.notes.controller;

import com.mediscreen.notes.model.Notes;
import com.mediscreen.notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NotesController {

    @Autowired
    private NotesService notesService;

    // GET

    @GetMapping(value = "/notesList")
    public List<Notes> findAllNotes() {
        List<Notes> notesList = notesService.findAllNotes();

        return notesList;
    }

    @GetMapping(value = "notesById/{id}")
    public Notes findNotesById(@PathVariable("id") Long id) {
        Notes notes = notesService.findNotesById(id);

        return notes;
    }

    // POST

    @PostMapping(value = "/notesSave", produces = MediaType.APPLICATION_JSON_VALUE)
    public Notes notesSave(@RequestBody Notes notes) {
        notesService.saveNotes(notes);
        Notes newNotes = notesService.findNotesById(notes.getId());

        return newNotes;
    }

    // DELETE

    @DeleteMapping(value = "/notesDelete/{id}")
    public Boolean notesDelete(@PathVariable Long id) {
        return notesService.deleteNotes(notesService.findNotesById(id));
    }

    // UPDATE

    @PutMapping(value = "/notesUpdate/{id}")
    public Notes notesUpdate(@RequestBody Notes notes) {

        return notesService.updateNotes(notes);
    }


}
