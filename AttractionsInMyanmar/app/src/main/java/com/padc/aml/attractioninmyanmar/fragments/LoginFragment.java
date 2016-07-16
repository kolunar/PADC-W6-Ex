package com.padc.aml.attractioninmyanmar.fragments;

/**
 * Created by user on 7/16/2016.
 */

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.padc.aml.attractioninmyanmar.R;
import com.padc.aml.attractioninmyanmar.activities.AttractionActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment {

    public static final String BARG_DUMMY_USERNAME = "dummy_username";
    private String dummy_username = "";

    public LoginFragment() {
    }

    public static LoginFragment newInstance(String defaultUsername){
        LoginFragment fragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString(LoginFragment.BARG_DUMMY_USERNAME, defaultUsername);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            dummy_username = bundle.getString(LoginFragment.BARG_DUMMY_USERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        final EditText etUserName = (EditText) view.findViewById(R.id.edtUserName);
        final EditText etPassword = (EditText) view.findViewById(R.id.edtPassword);

        etUserName.setText(dummy_username);

        Button btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString();
                //string password
                Intent intentLoginSummary = AttractionActivity.newIntent(username);
                //new Intent(getContext(), LoginSummaryActivity.class);
                //intentLoginSummary.putExtra("username_key",username);
                startActivity(intentLoginSummary);
            }
        });
        return view;
    }
}

