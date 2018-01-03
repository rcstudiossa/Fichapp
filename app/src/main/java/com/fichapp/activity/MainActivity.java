package com.fichapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.fichapp.fragment.CNESFragment;
import com.fichapp.fragment.FichaVisitaDTFragment;
import com.fichapp.fragment.ProfissionalFragment;
import com.fichapp.R;

public class MainActivity extends TemplateActivity implements NavigationView.OnNavigationItemSelectedListener {

    private MenuItem pesquisaBT;
    private boolean pesquisaAberta = false;
    private EditText pesquisaET;

    private String barTitleCNES;
    private String barTitleProfissionais;
    private String barTitleFichaVisitaDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.barTitleCNES = new String("Hospitais");
        this.barTitleProfissionais = new String("Profissionais");
        this.barTitleFichaVisitaDT = new String("Fichas de Visita");

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

        this.atualizarRodape();

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
    public boolean onPrepareOptionsMenu(Menu menu) {
        this.pesquisaBT = menu.findItem(R.id.bt_pesquisa);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.bt_pesquisa:
                handleMenuSearch();
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

    protected void handleMenuSearch(){
        ActionBar action = getSupportActionBar(); //get the actionbar

        if(pesquisaAberta){ //test if the search is open

            action.setDisplayShowCustomEnabled(false); //disable a custom view inside the actionbar
            action.setDisplayShowTitleEnabled(true); //show the title in the action bar

            //hides the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(pesquisaET.getWindowToken(), 0);

            //add the search icon in the action bar
            pesquisaBT.setIcon(getResources().getDrawable(R.drawable.ic_pesquisar));

            pesquisaAberta = false;
        } else { //open the search entry

            action.setDisplayShowCustomEnabled(true); //enable it to display a
            // custom view in the action bar.
            action.setCustomView(R.layout.search_bar);//add the custom view
            action.setDisplayShowTitleEnabled(false); //hide the title

            pesquisaET = (EditText)action.getCustomView().findViewById(R.id.et_pesquisa); //the text editor

            //this is a listener to do a search when the user clicks on search button
            pesquisaET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        //doSearch();
                        return true;
                    }
                    return false;
                }
            });


            pesquisaET.requestFocus();

            //open the keyboard focused in the edtSearch
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(pesquisaET, InputMethodManager.SHOW_IMPLICIT);


            //add the close icon
            pesquisaBT.setIcon(getResources().getDrawable(R.drawable.ic_cancel));

            pesquisaAberta = true;
        }
    }

}
