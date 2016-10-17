package com.cameramanager.restdemo.cameradetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cameramanager.restdemo.Injection;
import com.cameramanager.restdemo.R;
import com.cameramanager.restdemo.util.ActivityUtils;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public class CameraDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CAMERA_ID = "camera_id";

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameradetail);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        // Get the requested task id
        Long cameraId = getIntent().getLongExtra(EXTRA_CAMERA_ID, -1);

        CameraDetailFragment cameraDetailFragment = (CameraDetailFragment) getSupportFragmentManager().findFragmentById(R.id.item_detail_container);
        if(cameraDetailFragment == null) {
            cameraDetailFragment = CameraDetailFragment.newInstance(cameraId);

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), cameraDetailFragment, R.id.item_detail_container);
        }

        new CameraDetailPresenter( cameraId,
                Injection.provideCamerasRepository(getApplicationContext()),
                cameraDetailFragment,
                Injection.provideSchedulerProvider());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

