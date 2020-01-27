package hr.foi.mtlab.sportify.Turic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import hr.foi.mtlab.sportify.R;

public class popmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popmenu);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        double width = displayMetrics.widthPixels;
        double height = displayMetrics.heightPixels;

        getWindow().setLayout(400, 800);
    }
}
