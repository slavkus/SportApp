package hr.foi.mtlab.sportify.EventDetails;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gigamole.library.NavigationTabBar;

import java.util.ArrayList;

import hr.foi.mtlab.sportify.R;
import hr.foi.mtlab.sportify.Turic.MeniAdapter;

/*
* Aktivity koji prikazuje detalje o eventu
* te ucesnike koji su se odazvali, ili
* prihvaceni od strane organizatora
*
* Fragmenti:
*   fragment_detalji.xml & Detalji.java
*   fragment_ucesnici.xml & Ucesnici.java
* Adapter:
*   MeniAdapter.java
* */

public class EventDetailsActivity extends FragmentActivity {
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        pager = (ViewPager) findViewById(R.id.pager);
        MeniAdapter swip = new MeniAdapter(getSupportFragmentManager());
        pager.setAdapter(swip);

        NavigationTabBar meni = (NavigationTabBar) findViewById(R.id.meni);

        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        // Postavi nove ICONE za NavigationBar
        models.add(new NavigationTabBar.Model(
                getDrawable(R.mipmap.home), Color.parseColor("#BFBFBF") ));
        models.add(new NavigationTabBar.Model(
                getDrawable(R.mipmap.notifications), Color.parseColor("#BFBFBF") ));


        meni.setModels(models);
        meni.setViewPager(pager);

    }



}
