package com.padc.aml.attractioninmyanmar.fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.padc.aml.attractioninmyanmar.R;
import com.padc.aml.attractioninmyanmar.activities.AttractionActivity;
import com.padc.aml.attractioninmyanmar.dialogs.MyDatePickerDialog;

/**
 * Created by user on 7/16/2016.
 */
public class RegisterFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private EditText etDateOfBirth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_register,container,false);

        final EditText etRegUserName = (EditText) view.findViewById(R.id.etRegUserName);
        final EditText etRegPassword = (EditText) view.findViewById(R.id.etRegPassword);
        final EditText etRegEmail = (EditText) view.findViewById(R.id.etRegPassword);
        etDateOfBirth = (EditText) view.findViewById(R.id.etDateOfBirth);

        etDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

/*        final MyDatePickerDialog datePickerDialog = new MyDatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //newDate.set(year, monthOfYear, dayOfMonth);
                //fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },Calendar.YEAR,Calendar.MONTH, Calendar.DAY_OF_MONTH);*/

        Button btnRegister = (Button) view.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etRegUserName.getText().toString();
                String password = etRegPassword.getText().toString();
                String email = etRegEmail.getText().toString();
                String dob = etDateOfBirth.getText().toString();

                //Toast.makeText(HelloWorldApp.getContext(), "username:"+username+", sex:"+rdBtnGender.getText(), Toast.LENGTH_SHORT).show();
                Intent intentRegisterSummary = AttractionActivity.newRegIntent(username, password, email, dob);
                startActivity(intentRegisterSummary);
            }
        });

        return view;
    }

    private void showDatePicker(){
        DialogFragment newFragment = new MyDatePickerDialog();
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(getContext(), "Year : " + year + " Month : " + monthOfYear + " Day : " + dayOfMonth, Toast.LENGTH_SHORT).show();
        etDateOfBirth.setText(year+"-"+monthOfYear+"-"+dayOfMonth);
    }
}
