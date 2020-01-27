package hr.foi.mtlab.sportify.Turic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import hr.foi.mtlab.sportify.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ucesnici extends Fragment{

    String[] imena = {"Hello", "from", "the", "other", "side", "...", "...", "...", "...", "..."
            , "...", "...", "...", "...", "...", "..."};
    String[] prezimena= {"Hello", "from", "the", "other", "side", "...", "...", "...", "...", "..."
            , "...", "...", "...", "...", "...", "..."};
    int[] slike = {R.drawable.common_full_open_on_phone, R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone
            , R.drawable.common_full_open_on_phone};

    String[] veza = {"...", "...", "...", "...", "...", "...", "...", "...", "..."
            , "...", "...", "...", "...", "...", "...", "..."};

    ListView listView;
    View view;
    Intent popmenu_int;

    public Ucesnici() {
        // Required empty public constructor
    }

    /*
    * Prikaz ucesnika na eventu, imena i prezimena se trebaju smjestiti u polja "imena" "prezimena"
    * te profilne slike u polje "slike"
    *
    * Adapter za ListView je "AdapterListView" i jedno polje listViewa je layout "poljelist"
    *
    * */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view  = inflater.inflate(R.layout.fragment_ucesnici, container, false);
        popmenu_int = new Intent(getActivity(), popmenu.class);

        listView = (ListView) view.findViewById(R.id.listView);

        AdapterListView ListAdapt = new AdapterListView(getActivity(), imena, prezimena, slike);
        listView.setAdapter(ListAdapt);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                popmenu_int.putExtra("veza", veza[position]);
                startActivity(popmenu_int);
                return false;
            }
        });
        return view;
    }

    public static Ucesnici newInstance(int position) {
        Ucesnici timeLineFragment = new Ucesnici();
        Bundle args = new Bundle();
        args.putInt("ARG_COLUMN_COUNT", position);
        timeLineFragment.setArguments(args);
        return timeLineFragment;
    }

}