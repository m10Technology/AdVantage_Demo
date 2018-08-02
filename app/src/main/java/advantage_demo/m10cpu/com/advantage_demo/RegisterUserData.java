package advantage_demo.m10cpu.com.advantage_demo;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class RegisterUserData extends Fragment implements View.OnClickListener{

    private Button dateButton;
    private Calendar myCal = Calendar.getInstance();
    private Spinner genderSpinner;

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            myCal.set(Calendar.YEAR, year);
            myCal.set(Calendar.MONTH, month);
            myCal.set(Calendar.DAY_OF_MONTH, day);
            int fixedMonth = month+1;
            dateButton.setText(fixedMonth+"/"+day+"/"+year);
        }
    };

    public RegisterUserData() {
        // Required empty public constructor
    }

    public Boolean getGender(){
        if(genderSpinner.getSelectedItem().toString().equals("Male")){
            return true;
        }
        else{
            return false;
        }
    }

    public Calendar getMyCal() {
        return myCal;
    }

    public static RegisterUserData newInstance() {
        RegisterUserData fragment = new RegisterUserData();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register_user_data, container, false);
        dateButton = (Button) v.findViewById(R.id.birthButton);
        dateButton.setOnClickListener(this);
        genderSpinner = (Spinner)v.findViewById(R.id.spinner);
        return v;
    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        Log.i("Test","This works");
        new DatePickerDialog(this.getContext(), date, 2000, 0, 1).show();
    }

}
