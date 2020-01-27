package hr.foi.mtlab.sportify.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hr.foi.mtlab.sportify.ECA.EventCreationActivity;
import hr.foi.mtlab.sportify.EventDetails.EventDetailsActivity;
import hr.foi.mtlab.sportify.R;
import hr.foi.mtlab.sportify.dummy.DataItemTimeline;

/**
 * Created by Alen on 3.5.2016..
 */
public class TimeLineFragment extends android.support.v4.app.Fragment implements View.OnClickListener, TimelineItemInterface{

    private OnListFragmentInteractionListener mListener;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private RecyclerView recyclerView;
    private AdapterMainActivity adapter;

    public TimeLineFragment() {
    }

    public static TimeLineFragment newInstance(int position) {
        TimeLineFragment timeLineFragment = new TimeLineFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, position);
        timeLineFragment.setArguments(args);
        return timeLineFragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_timeline, container, false);
        FloatingActionButton ECAbutton = (FloatingActionButton) layout.findViewById(R.id.fabTime);
        ECAbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.fabTime){
                    Intent intent = new Intent(TimeLineFragment.this.getActivity(),EventCreationActivity.class);
                    startActivity(intent);
                }
            }
        });

        recyclerView = (RecyclerView) layout.findViewById(R.id.timeline_list);
        adapter = new AdapterMainActivity(getActivity(),getData(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }



    public   List<DataItemTimeline> getData(){
        List<DataItemTimeline> data = new ArrayList<>();
        int[] sport_backgrounds = {R.mipmap.basketball, R.mipmap.football, R.mipmap.hockey, R.mipmap.soccer, R.mipmap.tennis, R.mipmap. volleyball};
        String[] days = getResources().getStringArray(R.array.days);
        String[] months = getResources().getStringArray(R.array.months);
        String[] sports = getResources().getStringArray(R.array.sports);
        String[] titles = getResources().getStringArray(R.array.titles);


        for (int i = 0;i<days.length && i< sport_backgrounds.length ; i++){
            DataItemTimeline current = new DataItemTimeline();
            current.date =  days[i];
            current.month = months[i];
            current.event_sport = sports[i];
            current.sportId = sport_backgrounds[i];
            current.titles = titles[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //Ovo je mozda sada extra, jer je definirano gore u onCreateView-u, ali nisam probo removat

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabTime){
            Intent intent = new Intent(TimeLineFragment.this.getActivity(),EventCreationActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onTimelineItemClick(DataItemTimeline item) {
        Intent intent = new Intent(TimeLineFragment.this.getActivity(),EventDetailsActivity.class);
        startActivity(intent);
    }
}