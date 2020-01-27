package hr.foi.mtlab.sportify.Turic;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hr.foi.mtlab.sportify.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Detalji extends Fragment {


    public Detalji() {
        // Required empty public constructor
    }

    public static Detalji newInstance(int position) {
        Detalji timeLineFragment = new Detalji();
        Bundle args = new Bundle();
        args.putInt("ARG_COLUMN_COUNT", position);
        timeLineFragment.setArguments(args);
        return timeLineFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalji, container, false);
    }

}
