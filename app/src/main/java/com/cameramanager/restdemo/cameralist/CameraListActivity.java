package com.cameramanager.restdemo.cameralist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.cameramanager.restdemo.Injection;
import com.cameramanager.restdemo.R;
import com.cameramanager.restdemo.util.ActivityUtils;
import com.cameramanager.restdemo.zones.ZonesActivity;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public class CameraListActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private CameraListPresenter mCameraListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameras);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.camera_list_activity_title);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        // Set up the navigation drawer.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
        CameraListFragment cameraListFragment = (CameraListFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (cameraListFragment == null) {
            // Create the fragment
            cameraListFragment = CameraListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), cameraListFragment, R.id.contentFrame);
        }

        mCameraListPresenter = new CameraListPresenter(Injection.provideCameraTreeRepository(getApplicationContext()), cameraListFragment, Injection.provideSchedulerProvider());
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.zone_list_menu_item:
                                Intent intent =
                                        new Intent(CameraListActivity.this, ZonesActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                        | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                break;
                            case R.id.camera_list_menu_item:
                                // Do nothing, we're already on that screen
                                break;
                            default:
                                break;
                        }
                        // Close the navigation drawer when an item is selected.
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Open the navigation drawer when the home icon is selected from the toolbar.
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
