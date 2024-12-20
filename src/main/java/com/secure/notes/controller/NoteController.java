package com.secure.notes.controller;

import com.secure.notes.entity.Note;
import com.secure.notes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note createdNote(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        return  noteService.createNoteForUser(username,content);
    }

    @GetMapping
    public List<Note> getUserNotes(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return  noteService.getNotesForUser(username);
    }

    @PutMapping("/{noteId}")
    public Note updateNote(@PathVariable Long noteId,@RequestBody String content,
                           @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return  noteService.updateNoteForUser(noteId,content,username);
    }

    @DeleteMapping("/{noteId}")
    public void updateNote(@PathVariable Long noteId,
                           @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        noteService.deleteNoteForUser(noteId,username);
    }
}
