package com.example.codetride.tourguideapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list_view);

        final ArrayList<Content> contents = new ArrayList<>();

        contents.add(new Content("Top places", R.drawable.double_tree_hotel));
        contents.add(new Content("Popular Places", R.drawable.protea_hotel));
        contents.add(new Content("Top Hotels", R.drawable.president_hotel));
        ContentAdapter contentAdapter = new ContentAdapter(this, contents);
        listView.setAdapter(contentAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Content content = contents.get(i);

                switch (content.getName()){
                    case "Top places":
                        intent = new Intent(MainActivity.this,TopActivity.class);
                        startActivity(intent);
                        break;
                    case "Popular Places":
                        intent = new Intent(MainActivity.this,PopularActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        intent = new Intent(MainActivity.this,HotelsActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Email us");
                builder.setMessage("Do you want to send us an email?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final View view1 = view;
                        intent = new Intent(Intent.ACTION_SEND);
                        intent.setData(Uri.parse("mailto:"));
                        intent.setType("text/plain");
                        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject here");
                        intent.putExtra(android.content.Intent.EXTRA_TEXT, "Write your message here");
                        try {
                            startActivity(Intent.createChooser(intent, "Email via"));
                            finish();
                        }catch (android.content.ActivityNotFoundException ex){
                            Snackbar.make(view1, "Your device don't have email client installed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }
                });
               builder.setNegativeButton("No thanks", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                   }
               }) ;

                builder.create();
                builder.show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_gallery1) {
            Intent intent = new Intent(MainActivity.this, Gallery.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        switch (item.getItemId()){
            case R.id.nav_settings:
                intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            case R.id.nav_gallery:
                intent = new Intent(MainActivity.this,Gallery.class);
                startActivity(intent);
                break;
            case R.id.nav_location:
                intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.nav_top:
                intent = new Intent(MainActivity.this,TopActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_popular:
                intent = new Intent(MainActivity.this,PopularActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_hotel:
                intent = new Intent(MainActivity.this,HotelsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_email:

                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject here");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, "Write your message here");
                try {
                    startActivity(Intent.createChooser(intent, "Email via"));
                    finish();
                }catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(MainActivity.this,"Your device don't have email client installed",Toast.LENGTH_LONG).show();
                }

                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
