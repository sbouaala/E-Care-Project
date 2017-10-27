package fr.utbm.tx.e_care.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.utbm.tx.e_care.R;
import fr.utbm.tx.e_care.models.PatientModel;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.MyViewHolder> {

    private List<PatientModel> patientList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, address;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.patient_name);
            address = (TextView) view.findViewById(R.id.patient_address);
        }
    }


    public PatientAdapter(List<PatientModel> patientList) {
        this.patientList = patientList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patients_list_model, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PatientModel patient = patientList.get(position);
        holder.name.setText(patient.getName());
        holder.address.setText(patient.getAddress());
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }
}
