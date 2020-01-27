package hr.foi.mtlab.sportify;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnFocusChange;
import hr.foi.mtlab.sportify.Main.NewEventItem;

/**
 * Created by Slavkus Maximus on 11/25/2016.
 */
public class DialogHelper {
    private Context context;

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
    {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            selectedDate.set(Calendar.HOUR_OF_DAY, hourOfDay);
            selectedDate.set(Calendar.MINUTE,minute);

            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            editTime.setText(df.format(selectedDate.getTime()));
        }
    };

    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            selectedDate.set(Calendar.YEAR, year);
            selectedDate.set(Calendar.MONTH, monthOfYear);
            selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            editDate.setText(df.format(selectedDate.getTime()));
        }
    };

    @Bind(R.id.event_time)
    EditText editTime;

    @Bind(R.id.event_date)
    EditText editDate;

    Calendar selectedDate = Calendar.getInstance();

    public DialogHelper(Context context, View parentView) {
        this.context = context;
        ButterKnife.bind(this, parentView);
    }

    @OnFocusChange(R.id.event_time)
    public void onEditTimeClick(View view, boolean hasFocus) {
        if (!hasFocus) return;
        editTime.setInputType(InputType.TYPE_NULL);
        editTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(context, onTimeSetListener,
                        selectedDate.get(Calendar.HOUR_OF_DAY),
                        selectedDate.get(Calendar.MINUTE), true);
                NewEventItem.getInstance().setTime(selectedDate.getTime());
                timePickerDialog.show();
            }

        });
    }

    @OnFocusChange(R.id.event_date)
    public void onEditDateClick (View view, boolean hasFocus)
    {
        if(!hasFocus) return;
        editDate.setInputType(InputType.TYPE_NULL);
        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(context, onDateSetListener,
                        selectedDate.get(Calendar.YEAR),
                        selectedDate.get(Calendar.MONTH),
                        selectedDate.get(Calendar.DAY_OF_MONTH));
                NewEventItem.getInstance().setDate(selectedDate.getTime());
                datePickerDialog.show();
            }
        });
    }
}