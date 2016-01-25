package com.task.naviview.taskone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem menuItem) {
//                // cek apakah menuItem sudah diklik (checked) atau tidak
//                if(menuItem.isChecked())
//                    menuItem.setChecked(false);
//                else
//                    menuItem.setChecked(true);
//
//                // menutup drawer ketika menuItem diklik
//                drawer.closeDrawers();
//
//                switch (menuItem.getItemId()){
//                    //kode handle untuk tiap-tiap menu item
//                    case R.id.nav_home:
//                        Intent home = new Intent(MainActivity.this, Home.class);
//                        startActivity(home);
//                        Toast.makeText(MainActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.nav_profile:
//                        Intent profile = new Intent(MainActivity.this, Profile.class);
//                        startActivity(profile);
//                        Toast.makeText(MainActivity.this, "Profile clicked", Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.nav_contact:
//                        Intent contact = new Intent(MainActivity.this, Contact.class);
//                        startActivity(contact);
//                        Toast.makeText(MainActivity.this, "Contact clicked", Toast.LENGTH_SHORT).show();
//                        return true;
//
//                }
//                return true;
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // menghandle ketika tombol home diklik, Navigation View akan terbuka
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // menutup drawer ketika menuItem diklik
        drawer.closeDrawers();
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Intent home = new Intent(MainActivity.this, Home.class);
            startActivity(home);
            Toast.makeText(MainActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_profile) {
            Intent profile = new Intent(MainActivity.this, Profile.class);
            startActivity(profile);
            Toast.makeText(MainActivity.this, "Profile clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_contact) {
            Intent contact = new Intent(MainActivity.this, Contact.class);
            startActivity(contact);
            Toast.makeText(MainActivity.this, "Contact clicked", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
