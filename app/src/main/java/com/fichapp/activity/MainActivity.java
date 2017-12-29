package com.fichapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.TextView;

import com.fichapp.fragment.CNESFragment;
import com.fichapp.fragment.FichaVisitaDTFragment;
import com.fichapp.fragment.ProfissionalFragment;
import com.fichapp.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String barTitleCNES;
    private String barTitleProfissionais;
    private String barTitleFichaVisitaDT;
    private TextView nomeTV;
    private TextView cboTV;
    private TextView hospitalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.barTitleCNES = new String("Hospitais");
        this.barTitleProfissionais = new String("Profissionais");
        this.barTitleFichaVisitaDT = new String("Fichas de Visita");

        this.nomeTV = (TextView) findViewById(R.id.tv_nome_bar);
        this.cboTV = (TextView) findViewById(R.id.tv_cbo_bar);
        this.hospitalTV = (TextView) findViewById(R.id.tv_hospital_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String fragment = getIntent().getStringExtra("fragment");

        if (fragment != null) {

            if (fragment.equals("CNESFragment")) {
                setContent(new CNESFragment());
                getSupportActionBar().setTitle(this.barTitleCNES);

            } else if (fragment.equals("ProfissionalFragment")) {
                setContent(new ProfissionalFragment());
                getSupportActionBar().setTitle(this.barTitleProfissionais);

            } else if (fragment.equals("FichaVisitaDTFragment")) {
                setContent(new FichaVisitaDTFragment());
                getSupportActionBar().setTitle(this.barTitleFichaVisitaDT);

            }

        } else {
            setContent(new CNESFragment());
            getSupportActionBar().setTitle(this.barTitleCNES);
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
            getSupportActionBar().setTitle(this.barTitleCNES);

        } else if (id == R.id.nav_profissional) {
            setContent(new ProfissionalFragment());
            getSupportActionBar().setTitle(this.barTitleProfissionais);

        } else if (id == R.id.nav_fichaVisitaDT) {
            setContent(new FichaVisitaDTFragment());
            getSupportActionBar().setTitle(this.barTitleFichaVisitaDT);

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

}
