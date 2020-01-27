package hr.foi.mtlab.sportify.Turic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Zvjerka on 23.6.2017..
 */

public class MeniAdapter extends FragmentPagerAdapter {

    final Ucesnici uce = Ucesnici.newInstance(0);
    final Detalji deta = Detalji.newInstance(1);

    public MeniAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       if(position == 0) return deta;
       else if(position == 1) return uce;
       else
        return deta;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
