package fr.utbm.tx.e_care;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    private final int WAIT_TIMER = 2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, LoginActivity.class);
                Splash.this.startActivity(intent);
                Splash.this.finish();
            }
        }, WAIT_TIMER);
    }
}
