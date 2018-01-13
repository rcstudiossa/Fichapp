package com.fichapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.fichapp.fragment.CNESFragment;
import com.fichapp.fragment.FichaCadastroDTFragment;
import com.fichapp.fragment.FichaCadastroIDVFragment;
import com.fichapp.fragment.FichaVisitaDTFragment;
import com.fichapp.fragment.ProfissionalFragment;
import com.fichapp.R;

public class MainActivity extends TemplateActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String barTitleCNES;
    private String barTitleProfissionais;
    private String barTitleFichaVisitaDT;
    private String barTitleFichaCadastroDT;
    private String barTitleFichaCadastroIDV;

    private LinearLayout sairLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.barTitleCNES = new String("Hospitais");
        this.barTitleProfissionais = new String("Profissionais");
        this.barTitleFichaVisitaDT = new String("Visita Domiciliar/Territorial");
        this.barTitleFichaCadastroDT = new String("Cadastro Domiciliar/Territorial");
        this.barTitleFichaCadastroIDV = new String("Cadastro Individual");

        this.sairLL = (LinearLayout) findViewById(R.id.ll_sair);

        sairLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

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

            } else if (fragment.equals("FichaCadastroDTFragment")) {
                setContent(new FichaVisitaDTFragment());
                getSupportActionBar().setTitle(this.barTitleFichaCadastroDT);

            } else if (fragment.equals("FichaCadastroIDVFragment")) {
                setContent(new FichaVisitaDTFragment());
                getSupportActionBar().setTitle(this.barTitleFichaCadastroIDV);

            }

        } else {
            setContent(new FichaVisitaDTFragment());
            getSupportActionBar().setTitle(this.barTitleFichaVisitaDT);
        }

        atualizarRodape();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (getFragmentClass().equals(CNESFragment.class)) {
                    Intent intent = new Intent(MainActivity.this, CNESActivity.class);
                    startActivity(intent);
                } else if (getFragmentClass().equals(ProfissionalFragment.class)) {
                    Intent intent = new Intent(MainActivity.this, ProfissionalActivity.class);
                    startActivity(intent);
                } else if (getFragmentClass().equals(FichaVisitaDTFragment.class)) {
                    Intent intent = new Intent(MainActivity.this, FichaVisitaDTActivity.class);
                    startActivity(intent);
                } else if (getFragmentClass().equals(FichaCadastroDTFragment.class)) {
                    Intent intent = new Intent(MainActivity.this, FichaCadastroDTActivity.class);
                    startActivity(intent);
                } else if (getFragmentClass().equals(FichaCadastroIDVFragment.class)) {
                    Intent intent = new Intent(MainActivity.this, FichaCadastroIDVActivity.class);
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

        getMenuInflater().inflate(R.menu.main, menu);

        SearchView sv = (SearchView) menu.findItem(R.id.search_bar).getActionView();
        sv.setQueryHint("Pesquisar...");

        return true;
    }

    private Class<? extends Fragment> getFragmentClass() {

        Fragment f = getSupportFragmentManager().findFragmentById(R.id.conteudo_activity);

        return f.getClass();

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

        } else if (id == R.id.nav_ficha_visita_dt) {
            setContent(new FichaVisitaDTFragment());
            getSupportActionBar().setTitle(this.barTitleFichaVisitaDT);

        } else if (id == R.id.nav_ficha_cadastro_dt) {
            setContent(new FichaCadastroDTFragment());
            getSupportActionBar().setTitle(this.barTitleFichaCadastroDT);

        } else if (id == R.id.nav_ficha_cadastro_idv) {
            setContent(new FichaCadastroIDVFragment());
            getSupportActionBar().setTitle(this.barTitleFichaCadastroIDV);

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
