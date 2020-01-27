package hr.foi.mtlab.sportify.Main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gigamole.library.NavigationTabBar;

import java.util.ArrayList;

import hr.foi.mtlab.sportify.R;
import hr.foi.mtlab.sportify.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }
    private void initUI() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.mainVP);
        final TimeLineFragment timeLineFragment = TimeLineFragment.newInstance(0);
        final NotificationFragment notificationsFragment = NotificationFragment.newInstance(1);
        final ProfileFragment profileFragment = ProfileFragment.newInstance(2);
        final SettingsFragment settingsFragment = new SettingsFragment();

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                if (position == 0)
                    return timeLineFragment;
                else if (position == 1)
                    return notificationsFragment;
                else if (position == 2)
                    return profileFragment;
                else if (position == 3)
                    return settingsFragment;
                else return timeLineFragment;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });

        NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb);

        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();

        models.add(new NavigationTabBar.Model(
                getDrawable(R.mipmap.home), Color.parseColor("#EB173E") ));
        models.add(new NavigationTabBar.Model(
                getDrawable(R.mipmap.notifications), Color.parseColor("#AFE813") ));
        models.add(new NavigationTabBar.Model(
                getDrawable(R.mipmap.person), Color.parseColor("#FAA255") ));
        models.add(new NavigationTabBar.Model(
                getDrawable(R.mipmap.settings), Color.parseColor("#5A13E8")));

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

}
