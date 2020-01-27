package hr.foi.mtlab.sportify.Main;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hr.foi.mtlab.sportify.R;
import hr.foi.mtlab.sportify.dummy.DataItemNotification;

/**
 * Created by Alen on 21.5.2016..
 */


public class NotificationFragment  extends android.support.v4.app.Fragment implements NotificationItemInterface{

    private OnListFragmentInteractionListener mListener;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private RecyclerView recyclerView;
    private AdapterMainActivity adapter;

    public NotificationFragment() {
    }

    public static NotificationFragment newInstance(int position) {
        NotificationFragment notificationFragment = new NotificationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, position);
        notificationFragment.setArguments(args);
        return notificationFragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_notification, container, false);

        recyclerView = (RecyclerView) layout.findViewById(R.id.notifications_list);
        adapter = new AdapterMainActivity(getActivity(),getData(),1, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }



    public List<DataItemNotification> getData(){
        List<DataItemNotification> data = new ArrayList<>();
        int[] profil_pic = {R.mipmap.cura, R.mipmap.decko, R.mipmap.decko2};
        String[] days = getResources().getStringArray(R.array.days);
        String[] months = getResources().getStringArray(R.array.months);
        String[] notifications = getResources().getStringArray(R.array.notifications);


        for (int i = 0;i<days.length  && i< profil_pic.length ; i++){
            DataItemNotification current = new DataItemNotification();
            current.date =  days[i];
            current.month = months[i];
            current.notificationText = notifications[i];
            current.profilId = profil_pic[i];
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

    @Override
    public void OnNotifItemClick(DataItemNotification item) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder = builder.setItems(new CharSequence[]{"Prihvati poziv", "Odbij", "Posalji zahtjev", "Izbrisi"},
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i)
                        {
                            case 0:
                                Toast.makeText(getContext(), "Poziv prihvaćen.", 0).show();
                                break;
                            case 1:
                                Toast.makeText(getContext(), "Poziv odbijen.", 1).show();
                                break;
                            case 2:
                                Toast.makeText(getContext(), "Zahtjev poslan.", 2).show();
                                break;
                            case 3:
                                Toast.makeText(getContext(), "Notifikacija obrisana.", 3).show();
                                break;
                        }
                    }
                });
        builder.create().show();
    }
}
