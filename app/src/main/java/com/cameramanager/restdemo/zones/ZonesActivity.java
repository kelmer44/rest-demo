package com.cameramanager.restdemo.zones;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.cameramanager.restdemo.Injection;
import com.cameramanager.restdemo.R;
import com.cameramanager.restdemo.cameralist.CameraListActivity;
import com.cameramanager.restdemo.util.ActivityUtils;


public class ZonesActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    ZonesPresenter mZonesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zones);


        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

        ZonesFragment zonesFragment = (ZonesFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (zonesFragment == null) {
            // Create the fragment
            zonesFragment = ZonesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), zonesFragment, R.id.contentFrame);
        }

        // Create the presenter
        mZonesPresenter = new ZonesPresenter(Injection.provideZonesRepository(getApplicationContext()), zonesFragment, Injection.provideSchedulerProvider());
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.zone_list_menu_item:
                                // Do nothing, we're already on that screen

                                break;
                            case R.id.camera_list_menu_item:
                                Intent intent =
                                        new Intent(ZonesActivity.this, CameraListActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                        | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
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
