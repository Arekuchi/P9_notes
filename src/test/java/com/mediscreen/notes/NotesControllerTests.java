package com.mediscreen.notes;

import com.mediscreen.notes.DAO.NotesDAO;
import com.mediscreen.notes.controller.NotesController;
import com.mediscreen.notes.model.Notes;
import com.mediscreen.notes.service.NotesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class NotesControllerTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MockMvc mockMvc;

	@Autowired
	NotesService notesService;

	@MockBean
	NotesDAO notesDAO;

	@MockBean
	NotesController notesController;

	Long notesIdTest = 1L;
	Long patientIdTest = 4L;
	Date dateTest = Date.valueOf(LocalDate.now());

	List<Notes> notesList = new ArrayList<>();
//	Notes notesTest = new Notes(notesIdTest, patientIdTest, "notes string patient test");

	@Test
	public void findAllNotesTest() {

		when(notesController.findAllNotes()).thenReturn(notesList);
		notesController.findAllNotes();
		verify(notesController, times(1)).findAllNotes();
	}

	@Test
	public void findNotesByIdTest() {

//		when(notesController.findNotesByPatientId(notesIdTest)).thenReturn(notesTest);
//		notesController.findNotesByPatientId(notesIdTest);
//		verify(notesController, times(1)).findNotesByPatientId(notesIdTest);
	}

//	@Test
//	public void notesSaveTest() {
//
//		when(notesController.notesSave(notesTest)).thenReturn(any());
//		notesController.notesSave(notesTest);
//		verify(notesController, times(1)).notesSave(notesTest);
//	}

	@Test
	public void notesDeleteTest() {

//		when(notesController.notesDelete(notesIdTest)).thenReturn(true);
//		notesController.notesDelete(notesIdTest);
//		verify(notesController, times(1)).notesDelete(notesIdTest);
	}

	@Test
	public void findAllNotesMock() throws Exception {
//		this.mockMvc.perform(get("/notesList")).andExpect(status().isOk());
	}

	@Test
	public void findNotesByIdMock() throws Exception {
//		this.mockMvc.perform(get("notesById/1")).andExpect(status().isOk());
	}


}
