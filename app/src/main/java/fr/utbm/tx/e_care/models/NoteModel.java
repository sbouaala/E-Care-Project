package fr.utbm.tx.e_care.models;

/**
 * Created by ennajihihoussame on 26/10/2017.
 */

public class NoteModel {
    private String noteText;
    private String noteAuthor;
    private String noteDate;

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getNoteAuthor() {
        return noteAuthor;
    }

    public void setNoteAuthor(String noteAuthor) {
        this.noteAuthor = noteAuthor;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public NoteModel(String noteText, String noteAuthor, String noteDate) {

        this.noteText = noteText;
        this.noteAuthor = noteAuthor;
        this.noteDate = noteDate;
    }
}
