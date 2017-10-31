package fr.utbm.tx.e_care.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.utbm.tx.e_care.R;
import fr.utbm.tx.e_care.models.NoteModel;
import fr.utbm.tx.e_care.models.PatientModel;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private List<NoteModel> noteList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView noteText, noteAuthor, noteDate;

        public MyViewHolder(View view) {
            super(view);
            noteText = (TextView) view.findViewById(R.id.note_text);
            noteAuthor = (TextView) view.findViewById(R.id.note_author);
            noteDate = (TextView) view.findViewById(R.id.note_date);
        }
    }


    public NoteAdapter(List<NoteModel> noteList) {
        this.noteList = noteList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notes_model, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NoteModel note = noteList.get(position);
        holder.noteText.setText(note.getNoteText());
        holder.noteAuthor.setText(note.getNoteAuthor());
        holder.noteDate.setText(note.getNoteDate());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
