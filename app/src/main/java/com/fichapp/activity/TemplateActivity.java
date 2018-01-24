package com.fichapp.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.fichapp.R;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.util.Utilitario;

import java.lang.reflect.Array;

/**
 * Created by Rodrigo Costa on 29/12/2017.
 */

public class TemplateActivity extends AppCompatActivity {

    protected ProfissionalModel profissionalModel;
    protected TextView nomeBarTV;
    protected TextView cboBarTV;
    protected TextView hospitalBarTV;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        this.nomeBarTV = (TextView) findViewById(R.id.tv_nome_bar);
        this.cboBarTV = (TextView) findViewById(R.id.tv_cbo_bar);
        this.hospitalBarTV = (TextView) findViewById(R.id.tv_hospital_bar);

        atualizarRodape();

    }


    protected void desabilitaEditText(final CheckBox cb, final EditText et) {

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb.isChecked()) {
                    et.setEnabled(false);
                    et.getText().clear();
                    et.clearFocus();
                    et.setFocusable(false);
                    et.setFocusableInTouchMode(false);
                } else {
                    et.setEnabled(true);
                    et.setFocusable(true);
                    et.setFocusableInTouchMode(true);
                    et.requestFocus();
                }
            }
        });

    }

    protected void desabilitaEditText(final RadioGroup rg, final Integer valorIndex, final EditText et) {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));

                if (indexRg == valorIndex) {
                    et.setEnabled(false);
                    et.getText().clear();
                    et.clearFocus();
                    et.setFocusable(false);
                    et.setFocusableInTouchMode(false);
                } else {
                    et.setEnabled(true);
                    et.setFocusable(true);
                    et.setFocusableInTouchMode(true);
                    et.requestFocus();
                }
            }
        });

    }

    protected void desabilitaSpinner(final RadioGroup rg, final Integer valorIndex, final Spinner sp) {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));

                if (indexRg == valorIndex) {
                    sp.setEnabled(false);
                    sp.setClickable(false);
                    sp.setSelection(0);
                } else {
                    sp.setEnabled(true);
                    sp.setClickable(true);
                    sp.performClick();
                }
            }
        });

    }

    protected void desabilitaRadioGroup(final RadioGroup rg, final Integer valorIndex, final RadioGroup rgDesabilitado) {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));

                if (indexRg == valorIndex) {
                    for(int i = 0; i < rgDesabilitado.getChildCount(); i++) {
                        (rgDesabilitado.getChildAt(i)).setEnabled(false);
                    }
                    rgDesabilitado.clearCheck();

                } else {
                    for(int i = 0; i < rgDesabilitado.getChildCount(); i++) {
                        (rgDesabilitado.getChildAt(i)).setEnabled(true);
                    }
                }
            }
        });

    }

    protected void desabilitaLinearLayout(final RadioGroup rg, final Integer valorIndex, final LinearLayout ll) {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));

                if (indexRg == valorIndex) {
                    for(int i = 0; i < ll.getChildCount(); i++) {
                        (ll.getChildAt(i)).setEnabled(false);
                        ((CheckBox) ll.getChildAt(i)).setChecked(false);
                    }

                } else {
                    for(int i = 0; i < ll.getChildCount(); i++) {
                        (ll.getChildAt(i)).setEnabled(true);
                    }
                }
            }
        });

    }


    protected void atualizarRodape() {

        this.nomeBarTV.setText(prefs.getString("nome", ""));
        this.cboBarTV.setText("CBO:" + prefs.getString("cbo", ""));
        this.hospitalBarTV.setText(prefs.getString("cnes", ""));

    }

}
