package fr.utbm.tx.e_care.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import fr.utbm.tx.e_care.PatientDetailsActivity;
import fr.utbm.tx.e_care.R;
import fr.utbm.tx.e_care.adapters.NoteAdapter;
import fr.utbm.tx.e_care.adapters.PatientAdapter;
import fr.utbm.tx.e_care.adapters.RecyclerTouchListener;
import fr.utbm.tx.e_care.models.NoteModel;
import fr.utbm.tx.e_care.models.PatientModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientNotesFragment extends Fragment {

    protected RecyclerView notesRecyclerView;
    protected NoteAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected ArrayList<NoteModel> mDataset;
    protected View view;
    public PatientNotesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_patient_notes, container, false);


        notesRecyclerView = (RecyclerView) view.findViewById(R.id.notes_recyclerview);
        initDataSet();

        mAdapter= new NoteAdapter(mDataset);
        mLayoutManager= new LinearLayoutManager(getContext());
        notesRecyclerView.setLayoutManager(mLayoutManager);
        notesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        notesRecyclerView.setAdapter(mAdapter);
        notesRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), notesRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                NoteModel note = mDataset.get(position);
                Toast.makeText(getActivity().getApplicationContext(), note.getNoteText() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                NoteModel note = mDataset.get(position);
                Toast.makeText(getActivity().getApplicationContext(), note.getNoteText() + " is LONG PRESSED!", Toast.LENGTH_SHORT).show();
            }
        }));
        return view;
    }

    protected void initDataSet(){
        mDataset = new ArrayList<NoteModel>();
        mDataset.add(new NoteModel("For things to change you have to change","Jihn Rohn", "26/10"));
        mDataset.add(new NoteModel("Teemo On Duty","Teemo", "05/10"));
        mDataset.add(new NoteModel("Surprise I'm BACK","Jax", "10/01"));
        mDataset.add(new NoteModel("Dude, you're sooo noob","Aimen Abidi", "03/03"));
        mDataset.add(new NoteModel("Today is a good day to DIE","Jarvan IV", "17/05"));
        mDataset.add(new NoteModel("Our deepest fear is not that we are inadequate, Our deepest fear is that we are powerful beyond measure." +
                "It is our light not our darkness that most frightens us.","Marianne Williamson", "24/07"));

    }

}
