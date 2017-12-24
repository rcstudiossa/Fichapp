package com.fichapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

import com.fichapp.Fragment.CNESFragment;
import com.fichapp.Model.CNESModel;
import com.fichapp.Fragment.FichaVisitaDTFragment;
import com.fichapp.Fragment.ProfissionalFragment;
import com.fichapp.Model.FichaVisitaDTModel;
import com.fichapp.Model.ProfissionalModel;
import com.fichapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String fragment = getIntent().getStringExtra("fragment");

        if (fragment != null) {

            if (fragment.equals("CNESFragment")) {
                setContent(new CNESFragment());
            } else if (fragment.equals("ProfissionalFragment")) {
                setContent(new ProfissionalFragment());
            } else if (fragment.equals("FichaVisitaDTFragment")) {
                setContent(new FichaVisitaDTFragment());
            }

        } else {
            setContent(new CNESFragment());
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Fragment f = getSupportFragmentManager().findFragmentById(R.id.conteudo_activity);

                if (f.getClass().equals(CNESFragment.class)) {
                    Intent intent = new Intent(MainActivity.this, CNESActivity.class);
                    startActivity(intent);
                } else if (f.getClass().equals(ProfissionalFragment.class)) {
                    Intent intent = new Intent(MainActivity.this, ProfissionalActivity.class);
                    startActivity(intent);
                } else if (f.getClass().equals(FichaVisitaDTFragment.class)) {
                    Intent intent = new Intent(MainActivity.this, FichaVisitaDTActivity.class);
                    startActivity(intent);
                }

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cnes) {
            setContent(new CNESFragment());
        } else if (id == R.id.nav_profissional) {
            setContent(new ProfissionalFragment());
        } else if (id == R.id.nav_fichaVisitaDT) {
            setContent(new FichaVisitaDTFragment());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void setContent(Fragment content) {
        final FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.conteudo_activity, content);
        fragTransaction.commit();
    }

    public List<ProfissionalModel> getSetProfissionalList(int qtd){
        String[] cboEnome = new String[]{"2231-46 - Dr. Paulo Freitas", "2231-06 - Dra. Natália Costa", "2231-31 - Dr. Alexandre Matos"};
        List<ProfissionalModel> listAux = new ArrayList<>();

        for(int i = 0; i < qtd; i++){
            ProfissionalModel c = new ProfissionalModel(cboEnome[i % cboEnome.length]);
            listAux.add(c);
        }
        return(listAux);
    }

    public List<FichaVisitaDTModel> getSetCarList(int qtd){
        String[] prontuarioEnome = new String[]{"254689 - Rodrigo Costa", "485312 - Roque Souza", "648312 - Patrícia Duarte"};
        List<FichaVisitaDTModel> listAux = new ArrayList<>();

        for(int i = 0; i < qtd; i++){
            FichaVisitaDTModel c = new FichaVisitaDTModel( prontuarioEnome[i % prontuarioEnome.length]);
            listAux.add(c);
        }
        return(listAux);
    }





}
