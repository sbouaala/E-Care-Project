package fr.utbm.tx.e_care;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import fr.utbm.tx.e_care.Fragments.DashboardFragment;
import fr.utbm.tx.e_care.Fragments.PatientNotesFragment;
import fr.utbm.tx.e_care.Fragments.PatientProfilFragment;

public class PatientDetailsActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_profil:
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container_patient, new PatientProfilFragment(), "Patient");
                    fragmentTransaction.commit();
                    return true;
                case R.id.nav_notes:
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container_patient, new PatientNotesFragment(), "Patient Notes");
                    fragmentTransaction.commit();
                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.menu_patient);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        PatientProfilFragment frag = new PatientProfilFragment();
        fragmentTransaction.add(R.id.container_patient, frag, "profil");
        fragmentTransaction.commit();
    }
}
