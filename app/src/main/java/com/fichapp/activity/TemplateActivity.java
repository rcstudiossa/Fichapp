package com.fichapp.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.fichapp.R;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoModel;
import com.fichapp.util.Utilitario;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Rodrigo Costa on 29/12/2017.
 */

public class TemplateActivity extends AppCompatActivity {

    protected ProfissionalModel profissionalModel;
    protected TextView nomeBarTV;
    protected TextView cboBarTV;
    protected TextView hospitalBarTV;

    protected SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        this.nomeBarTV = (TextView) findViewById(R.id.tv_nome_bar);
        this.cboBarTV = (TextView) findViewById(R.id.tv_cbo_bar);
        this.hospitalBarTV = (TextView) findViewById(R.id.tv_hospital_bar);

        atualizarRodape();

    }

    protected void desabilitaEditText(final EditText et) {
        et.setEnabled(false);
        et.getText().clear();
        et.clearFocus();
        et.setFocusable(false);
        et.setFocusableInTouchMode(false);
    }

    protected void habilitaEditText(final EditText et) {
        et.setEnabled(true);
        et.setFocusable(true);
        et.setFocusableInTouchMode(true);
        et.requestFocus();
    }

    protected void desabilitaRadioGroup(final RadioGroup rg) {
        for (int i = 0; i < rg.getChildCount(); i++) {
            (rg.getChildAt(i)).setEnabled(false);
        }
        rg.clearCheck();
    }

    protected void habilitaRadioGroup(final RadioGroup rg) {
        for (int i = 0; i < rg.getChildCount(); i++) {
            (rg.getChildAt(i)).setEnabled(true);
        }
    }

    protected void desabilitarComponentes(View componente) {

       componente.setEnabled(false);

        if (componente instanceof CheckBox) {
            ((CheckBox) componente).setChecked(false);
        } else if (componente instanceof EditText) {
            ((EditText) componente).getText().clear();
        } else if (componente instanceof Spinner) {
            ((Spinner) componente).setSelection(0);
        } else if (componente instanceof RadioGroup) {
            desabilitaRadioGroup((RadioGroup) componente);
        } else if (componente instanceof TextInputLayout) {
            desabilitaLinearLayout((TextInputLayout) componente);
        } else if (componente instanceof LinearLayout) {
            desabilitaLinearLayout((LinearLayout) componente);
        } else if (componente instanceof FrameLayout) {
            desabilitaLinearLayout((FrameLayout) componente);
        }
    }

    protected void habilitarComponentes(View componente) {

        componente.setEnabled(true);

        if (componente instanceof TextInputLayout) {
            habilitaLinearLayout((TextInputLayout) componente);
        } else if (componente instanceof LinearLayout) {
            habilitaLinearLayout((LinearLayout) componente);
        } else if (componente instanceof FrameLayout) {
            habilitaLinearLayout((FrameLayout) componente);
        } else if (componente instanceof RadioGroup) {
            habilitaRadioGroup((RadioGroup) componente);
        }

    }

    protected void desabilitaLinearLayout(final LinearLayout ll) {

        for (int i = 0; i < ll.getChildCount(); i++) {
            desabilitarComponentes(ll.getChildAt(i));
        }
    }

    protected void desabilitaLinearLayout(final FrameLayout ll) {

        for (int i = 0; i < ll.getChildCount(); i++) {
            desabilitarComponentes(ll.getChildAt(i));
        }
    }

    protected void habilitaLinearLayout(final LinearLayout ll) {
        for (int i = 0; i < ll.getChildCount(); i++) {
            habilitarComponentes(ll.getChildAt(i));
        }
    }

    protected void habilitaLinearLayout(final FrameLayout ll) {
        for (int i = 0; i < ll.getChildCount(); i++) {
            habilitarComponentes(ll.getChildAt(i));
        }
    }

    protected void desabilitaEditText(final CheckBox cb, final EditText et) {

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb.isChecked()) {
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

        Integer[] i = {valorIndex};

        desabilitaEditText(rg, i, et);
    }

    protected void validaHabilitacaoEditText(final EditText et, boolean flagHabilitacao) {

        if (!flagHabilitacao) {
            et.setEnabled(false);
            et.getText().clear();
            et.clearFocus();
            et.setFocusable(false);
        } else {
            et.setEnabled(true);
            et.setFocusable(true);
            et.setFocusableInTouchMode(true);
        }

    }

    protected void validaHabilitacaoComponente(final View componente, boolean flagHabilitacao) {
        if (!flagHabilitacao) {
            componente.setEnabled(false);
            componente.clearFocus();
            componente.setFocusable(false);
        } else {
            componente.setEnabled(true);
            componente.setFocusable(true);
            componente.setFocusableInTouchMode(true);
        }
    }

    protected void desabilitaEditText(final RadioGroup rg, final Integer[] valorIndex, final EditText et) {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));

                for (int i = 0; i < valorIndex.length; i++) {

                    if (indexRg == valorIndex[i]) {
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
                    //sp.performClick();
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
                    for (int i = 0; i < rgDesabilitado.getChildCount(); i++) {
                        (rgDesabilitado.getChildAt(i)).setEnabled(false);
                    }
                    rgDesabilitado.clearCheck();

                } else {
                    for (int i = 0; i < rgDesabilitado.getChildCount(); i++) {
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
                    for (int i = 0; i < ll.getChildCount(); i++) {
                        desabilitarComponentes(ll.getChildAt(i));
                    }

                } else {
                    for (int i = 0; i < ll.getChildCount(); i++) {
                        habilitarComponentes(ll.getChildAt(i));
                    }
                }
            }
        });

    }


    protected Integer getPosicaoSelecionadoRG(RadioGroup radioGroup) {

        return radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()));
    }

    protected void ativaRG(RadioGroup radioGroup, Integer posicao) {

        if (!Utilitario.isEmpty(posicao) && !Utilitario.isEmpty(radioGroup.getChildAt(posicao))) {
            ((RadioButton) radioGroup.getChildAt(posicao)).setChecked(true);
        }
    }


    protected void atualizarRodape() {

        this.nomeBarTV.setText(prefs.getString("nome", ""));
        this.cboBarTV.setText("CBO: " + prefs.getString("cbo", ""));
        this.hospitalBarTV.setText(prefs.getString("cnes", ""));

    }

    protected void carregarSpinnerTipoImovel(Spinner spinner) {

        ArrayAdapter<TipoModel> adapterTipoImovel = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboTipoImovel());
        spinner.setAdapter(adapterTipoImovel);
        adapterTipoImovel.setDropDownViewResource(R.layout.spinner_dropdown_item);

    }

    protected void updateLabel(EditText editText, Calendar calendar) {

        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

        editText.setText(sdf.format(calendar.getTime()));
    }

    protected void configDatePicker(final Context context, String data, final EditText campo) {

        final Calendar calendar = Calendar.getInstance();
        if (!Utilitario.isEmpty(data)) {
            calendar.setTime(Utilitario.getDate(data));
        }

        final DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(campo, calendar);
            }
        };

        campo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(context, listener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

}
