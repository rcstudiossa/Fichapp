package com.fichapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.TextView;
import android.widget.Toast;

import com.fichapp.fragment.CNESFragment;
import com.fichapp.fragment.FichaCadastroDTFragment;
import com.fichapp.fragment.FichaCadastroIndividualFragment;
import com.fichapp.fragment.FichaVisitaDTFragment;
import com.fichapp.fragment.ProfissionalFragment;
import com.fichapp.R;
import com.fichapp.util.Utilitario;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String barTitleCNES;
    private String barTitleProfissionais;
    private String barTitleFichaVisitaDT;
    private String barTitleFichaCadastroDT;
    private String barTitleFichaCadastroIndividual;

    private FloatingActionButton fab;
    private LinearLayout sairLL;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    private TextView tvNomeBar;
    private TextView tvCboBar;
    private TextView tvHospitalBar;

    private TextView tvInicial;

    boolean doubleBackToExitPressedOnce = false;
    private Long usuarioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);

        this.definirComponentes();

        sairLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        this.setFragments();

        this.actionFab();

        this.atualizarDadosUsuarioLogado();

        this.configDrawer();

    }

    private void definirComponentes() {

        this.sairLL = (LinearLayout) findViewById(R.id.ll_sair);
        this.fab = (FloatingActionButton) findViewById(R.id.fab_gravar);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navigationView = (NavigationView) findViewById(R.id.nav_view);

        tvInicial = (TextView) findViewById(R.id.tv_inicial);
        View v = navigationView.getHeaderView(0);
        tvNomeBar = v.findViewById(R.id.tv_capa_nome_bar);
        tvCboBar = v.findViewById(R.id.tv_capa_cbo_bar);
        tvHospitalBar = v.findViewById(R.id.tv_capa_hospital_bar);
        ((TextView) v.findViewById(R.id.tv_versao)).setText(Utilitario.getVersao());

    }

    private void atualizarDadosUsuarioLogado() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        this.usuarioId = prefs.getLong("id", 0);
        this.tvNomeBar.setText("Usuário: " + prefs.getString("nome", ""));
        this.tvCboBar.setText("CBO: " + prefs.getString("cbo", ""));
        this.tvHospitalBar.setText("Origem: " + prefs.getString("cnes", ""));

    }

    protected void setContent(Fragment content) {
        final FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.conteudo_activity, content);
        fragTransaction.commit();

    }

    private void actionFab() {

        this.fab.setOnClickListener(new View.OnClickListener() {

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
                } else if (getFragmentClass().equals(FichaCadastroIndividualFragment.class)) {
                    Intent intent = new Intent(MainActivity.this, FichaCadastroIndividualActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    private void setFragments() {

        this.barTitleCNES = new String("UBS");
        this.barTitleProfissionais = new String("Profissionais");
        this.barTitleFichaVisitaDT = new String("Visita Domiciliar/Territorial");
        this.barTitleFichaCadastroDT = new String("Cadastro Domiciliar/Territorial");
        this.barTitleFichaCadastroIndividual = new String("Cadastro Individual");

        String fragment = getIntent().getStringExtra("fragment");

        if (fragment != null) {

            habilitarComandosSemFragment(Boolean.TRUE);

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
                setContent(new FichaCadastroDTFragment());
                getSupportActionBar().setTitle(this.barTitleFichaCadastroDT);

            } else if (fragment.equals("FichaCadastroIndividualFragment")) {
                setContent(new FichaCadastroIndividualFragment());
                getSupportActionBar().setTitle(this.barTitleFichaCadastroIndividual);

            }

        } else {
            getSupportActionBar().setTitle("Cadastro de Fichas");
            habilitarComandosSemFragment(Boolean.FALSE);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    drawer.openDrawer(GravityCompat.START);
                }
            }, 500);
        }
    }

    private void habilitarComandosSemFragment(Boolean flagHabilitar) {

        if (flagHabilitar) {
            this.fab.setVisibility(View.VISIBLE);
            this.tvInicial.setVisibility(View.GONE);
        } else {
            this.fab.setVisibility(View.GONE);
            this.tvInicial.setVisibility(View.VISIBLE);
        }


    }

    private void configDrawer() {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        Menu menu = navigationView.getMenu();
        if (!usuarioId.equals(1L)) {
            MenuItem item = menu.getItem(0);
            item.setVisible(false);
        } else {
            MenuItem item = menu.getItem(1);
            item.setVisible(false);
        }

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                this.logout();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Clique novamente para sair", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);

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

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        habilitarComandosSemFragment(Boolean.TRUE);

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
            setContent(new FichaCadastroIndividualFragment());
            getSupportActionBar().setTitle(this.barTitleFichaCadastroIndividual);

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void logout() {

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

    }

}
