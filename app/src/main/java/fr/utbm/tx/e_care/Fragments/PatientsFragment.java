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
import fr.utbm.tx.e_care.adapters.PatientAdapter;
import fr.utbm.tx.e_care.adapters.RecyclerTouchListener;
import fr.utbm.tx.e_care.models.PatientModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientsFragment extends Fragment {

    protected RecyclerView patientsRecyclerView;
    protected PatientAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected ArrayList<PatientModel> mDataset;
    protected View view;
    private static final String TAG = "PatientsFragment";

    public PatientsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_patients, container, false);

        patientsRecyclerView = (RecyclerView) view.findViewById(R.id.patients_recyclerview);
        initDataSet();

        mAdapter= new PatientAdapter(mDataset);
        mLayoutManager= new LinearLayoutManager(getContext());
        patientsRecyclerView.setLayoutManager(mLayoutManager);
        patientsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        patientsRecyclerView.setAdapter(mAdapter);
        patientsRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), patientsRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                PatientModel patient = mDataset.get(position);
                Toast.makeText(getActivity().getApplicationContext(), patient.getName() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), PatientDetailsActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }

    protected void initDataSet(){
        mDataset = new ArrayList<PatientModel>();
        mDataset.add(new PatientModel("Azir","Shurima"));
        mDataset.add(new PatientModel("Amumu","Shurima"));
        mDataset.add(new PatientModel("Xerath","Shurima"));
        mDataset.add(new PatientModel("taliah","Shurima"));
        mDataset.add(new PatientModel("Gankplank","Bilgewater"));
        mDataset.add(new PatientModel("Graves","Bilgewater"));
        mDataset.add(new PatientModel("MissFortune","Bilgewater"));
        mDataset.add(new PatientModel("Ahri","Ionia"));
        mDataset.add(new PatientModel("Kayn","Ionia"));
        mDataset.add(new PatientModel("Ass","Freljord"));
        mDataset.add(new PatientModel("Trynda die Please","Freljord"));
        mDataset.add(new PatientModel("Braum","Freljord"));
        mDataset.add(new PatientModel("Chop Chop Olaf","Freljord"));
        mDataset.add(new PatientModel("it's the Troll","Freljord"));
        mDataset.add(new PatientModel("Dyrus","Noxus"));
        mDataset.add(new PatientModel("Katanira","Noxus"));
        mDataset.add(new PatientModel("Kled","Noxus"));
        mDataset.add(new PatientModel("Cassiopeia","Noxus"));
        mDataset.add(new PatientModel("LeBlanc","Noxus"));
        }

}
