package hr.foi.mtlab.sportify.ECA;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import hr.foi.mtlab.sportify.EventDetails.EventDetailsActivity;
import hr.foi.mtlab.sportify.Facebook.SplashActivity;
import hr.foi.mtlab.sportify.GoogleMaps.MapsActivity;
import hr.foi.mtlab.sportify.GoogleMaps.MapsActivity;
import hr.foi.mtlab.sportify.Main.MainActivity;
import hr.foi.mtlab.sportify.Main.NewEventItem;
import hr.foi.mtlab.sportify.Main.TimeLineFragment;
import hr.foi.mtlab.sportify.R;


public class ChooseEventTypeFragment extends android.support.v4.app.Fragment {

    public ChooseEventTypeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_event_type,container,false);

        final Calendar selectedDate = Calendar.getInstance();
        ImageButton pinLocation = (ImageButton) view.findViewById(R.id.pin);
        pinLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.pin){
                    Intent intent = new Intent(ChooseEventTypeFragment.this.getActivity(),MapsActivity.class);
                    startActivity(intent);
                }
            }
        });
        final EditText name = (EditText) view.findViewById(R.id.event_name);
        final EditText description = (EditText) view.findViewById(R.id.event_description);
        final EditText date = (EditText) view.findViewById(R.id.event_date);
        final EditText time = (EditText) view.findViewById(R.id.event_time);
        final EditText price = (EditText) view.findViewById(R.id.event_price);
        final EditText repeats = (EditText) view.findViewById(R.id.event_repeats);
        final EditText place = (EditText) view.findViewById(R.id.event_place);
        final EditText sport = (EditText) view.findViewById(R.id.event_sport);
        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabAccept);
        place.setText(NewEventItem.getInstance().getLocation());

        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewEventItem.getInstance().setPrice(Double.parseDouble(price.getText().toString()));
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().length()==0||sport.getText().length()==0||
                        repeats.getText().length()==0||description.getText().length()==0||place.length()==0)
                    Toast.makeText(getActivity(), "Please enter all required infomation.", Toast.LENGTH_SHORT).show();
                else {
                    NewEventItem.getInstance().setName(name.getText().toString());
                    NewEventItem.getInstance().setSport(sport.getText().toString());
                    NewEventItem.getInstance().setNumberOfRepeats(Integer.parseInt(repeats.getText().toString()));
                    NewEventItem.getInstance().setDescription(description.getText().toString());
                    getActivity().finish();
                }
            }
        });

        repeats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewEventItem.getInstance().setNumberOfRepeats(Integer.parseInt(repeats.getText().toString()));
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        selectedDate.set(Calendar.YEAR, year);
                        selectedDate.set(Calendar.MONTH, monthOfYear);
                        selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        SimpleDateFormat sdf = new SimpleDateFormat("dd. MMMM yyyy");
                        date.setText(sdf.format(selectedDate.getTime()));
                        NewEventItem.getInstance().setDate(selectedDate.getTime());
                    }
                }, selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tpd = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedDate.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        selectedDate.set(Calendar.MINUTE, minute);

                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                        time.setText(sdf.format(selectedDate.getTime()));
                        NewEventItem.getInstance().setTime(selectedDate.getTime());
                    }
                }, selectedDate.get(Calendar.HOUR_OF_DAY), selectedDate.get(Calendar.MINUTE), true);
                tpd.show();
            }
        });

        return view;
    }
}
