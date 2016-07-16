package com.padc.aml.attractioninmyanmar.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.padc.aml.attractioninmyanmar.AttractionApp;
import com.padc.aml.attractioninmyanmar.R;
import com.padc.aml.attractioninmyanmar.data.vos.AttractionVO;
import com.padc.aml.attractioninmyanmar.fragments.AttractionFragment;

public class AttractionActivity extends AppCompatActivity implements AttractionFragment.ControllerAttractionItem{

    private static final String IE_USERNAME = "username_key";

    public static Intent newIntent(String username){
        Context context = AttractionApp.getContext();
        Intent intentLoginSummary = new Intent(context, AttractionActivity.class);
        intentLoginSummary.putExtra(IE_USERNAME, username);
        return intentLoginSummary;
    }

    private static final String IE_PASSWORD = "password_key";
    private static final String IE_EMAIL = "email_key";
    private static final String IE_DOB = "dob_key";

    public static Intent newRegIntent(String username, String password, String email, String dob){
        Context context = AttractionApp.getContext();
        Intent intentRegisterSummary = new Intent(context, AttractionActivity.class);
        intentRegisterSummary.putExtra(IE_USERNAME, username);
        intentRegisterSummary.putExtra(IE_PASSWORD, password);
        intentRegisterSummary.putExtra(IE_EMAIL, email);
        intentRegisterSummary.putExtra(IE_DOB, dob);
        return intentRegisterSummary;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        */

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (savedInstanceState == null) {
            Toast.makeText(AttractionApp.getContext(), "AttractionActivity::onCreate::savedInstanceState", Toast.LENGTH_SHORT).show();
            AttractionFragment fragment = AttractionFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapAttraction(AttractionVO event, ImageView imageView) {

        Intent intent = AttractionDetailActivity.newIntent(event.getAttractionTitle());
        // to gracefully fallback if version leass than 21
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                    new Pair<View, String>(imageView, getString(R.string.attraction_stock_photo_shared_transition)));

            //ActivityCompat.startActivity();
            startActivity(intent, activityOptionsCompat.toBundle());
        }
        else {
            startActivity(intent);
        }
    }
}
