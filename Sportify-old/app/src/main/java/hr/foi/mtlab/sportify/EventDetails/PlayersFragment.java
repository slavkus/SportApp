package hr.foi.mtlab.sportify.EventDetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hr.foi.mtlab.sportify.Main.AdapterMainActivity;
import hr.foi.mtlab.sportify.R;
import hr.foi.mtlab.sportify.dummy.DataItemPlayers;


/**
 * Created by TheSlavkusMaximus on 19/04/2017.
 */

public class PlayersFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private AdapterEventDetails adapterEventDetails;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_players, container, false);

        recyclerView = (RecyclerView) layout.findViewById(R.id.player_list);
        adapterEventDetails = new AdapterEventDetails(getActivity(),getData());
        recyclerView.setAdapter(adapterEventDetails);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }

    public List<DataItemPlayers> getData(){
        List<DataItemPlayers> data = new ArrayList<>();
        int[] profil_pic = {R.mipmap.cura, R.mipmap.decko, R.mipmap.decko2};
        String[] players = getResources().getStringArray(R.array.notifications);


        for (int i = 0; i< profil_pic.length ; i++){
            DataItemPlayers current = new DataItemPlayers();
            current.playerName = players[i];
            current.profilId = profil_pic[i];
            data.add(current);
        }
        return data;
    }
}

