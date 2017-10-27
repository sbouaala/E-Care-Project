package fr.utbm.tx.e_care.adapters;

/**
 * Created by ennajihihoussame on 05/06/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import fr.utbm.tx.e_care.R;
import fr.utbm.tx.e_care.models.PatientModel;


/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class PatientsListAdapter_trm extends RecyclerView.Adapter<PatientsListAdapter_trm.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private String[] mDataSet;
    private ArrayList<PatientModel> TDataSet;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public PatientsListAdapter_trm(ArrayList<PatientModel> dataSet) {
        TDataSet = dataSet;
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.patients_list_model, viewGroup, false);
        return new ViewHolder(v);
    }

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        PatientModel mPatientModel = TDataSet.get(position);

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getPatientName().setText(mPatientModel.getName());
        viewHolder.getPatientAddress().setText(mPatientModel.getAddress());
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return TDataSet.size();
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView patientName;
        private final TextView patientAddress;
        private Context context;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");

                }
            });
            patientName = (TextView) v.findViewById(R.id.patient_name);
            patientAddress = (TextView) v.findViewById(R.id.patient_address);
        }


        public void setOnclick(Context context) {
            this.context = context;
        }

        public TextView getPatientName() {
            return patientName;
        }

        public TextView getPatientAddress() {
            return patientAddress;
        }

    }
}

