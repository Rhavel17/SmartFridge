package com.example.smartfridge.controlcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import com.example.smartfridge.R;

import java.util.Calendar;

public class ControlCenterActivity extends AppCompatActivity {
    Calendar cal;
    EditText time, date;
    TimePickerDialog picker;
    DatePickerDialog datePicker;
    int hour, min, day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cal = Calendar.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_center);

        initializeTime();
        initializeDate();
    }

    //Initializes EditText and adds TimePicker functionality when clicked
    public void initializeTime() {
        hour = cal.get(Calendar.HOUR);
        min = cal.get(Calendar.MINUTE);

        time = (EditText) findViewById(R.id.textSetTime);
        time.setInputType(InputType.TYPE_NULL);

        //Set EditText text to be current time
        if(min < 10) {
            time.setText(hour + ":0" + min);
        } else {
            time.setText(hour + ":" + min);
        }

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker = new TimePickerDialog(ControlCenterActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        if(i1 < 10) {
                            time.setText(i + ":0" + i1);
                        } else {
                            time.setText(i + ":" + i1);
                        }
                    }
                }, hour, min, false);

                picker.show();
            }
        });
    }

    //Initializes EditText and adds DatePicker functionality when clicked
    public void initializeDate() {
        //Get current date elements from Calendar object
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH); //Note months are indexed starting at zero (Jan -> 0)
        year = cal.get(Calendar.YEAR);

        //Pair EditText to local variable and set input type
        date = (EditText) findViewById(R.id.textSetDate);
        date.setInputType(InputType.TYPE_NULL);

        //Set EditText text to be current time
        date.setText((month + 1) + "/" + day + "/" + year);

        //Create onClick listener on date variable
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker = new DatePickerDialog(ControlCenterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        date.setText((month + 1) + "/" + dayOfMonth + "/" + year);
                    }
                }, year, month, day);

                datePicker.show();
            }
        });
    }
}