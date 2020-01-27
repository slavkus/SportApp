package hr.foi.mtlab.sportify.ECA;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import hr.foi.mtlab.sportify.R;

public class EventCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creation_layout);

        ChooseEventTypeFragment chooseEventTypeFragment = new ChooseEventTypeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.choose_type_container,chooseEventTypeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
