package com.joaonery.exregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.joaonery.exregister.model.Person;

import java.util.ArrayList;

/**
 * @author João Nery
 * @since 31/07/2018
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etAge;
    private RadioGroup rgGender;
    private RadioButton rdMale;
    private RadioButton rdFemale;
    private CheckBox chDonut;
    private CheckBox chPizza;
    private CheckBox chCake;
    private CheckBox chToast;
    private Button btOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.ma_et_name);
        etAge = findViewById(R.id.ma_et_age);
        rgGender = findViewById(R.id.ma_rg_gender);
        rdMale = findViewById(R.id.ma_rd_male);
        rdFemale = findViewById(R.id.ma_rd_female);
        chDonut = findViewById(R.id.ma_ch_donut);
        chPizza = findViewById(R.id.ma_ch_pizza);
        chCake = findViewById(R.id.ma_ch_cake);
        chToast = findViewById(R.id.ma_ch_toast);
        btOK = findViewById(R.id.ma_bt_ok);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty() || etAge.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.ma_toast_error), Toast.LENGTH_LONG).show();
                }else{
                    Person p = new Person(MainActivity.this);

                    p.setName(etName.getText().toString());
                    p.setAge(Integer.parseInt(etAge.getText().toString()));

                    if(rgGender.getCheckedRadioButtonId() == rdMale.getId()){
                        p.setGender(rdMale.getText().toString());
                    }else if(rgGender.getCheckedRadioButtonId() == rdFemale.getId()){
                        p.setGender(rdFemale.getText().toString());
                    }else{
                        p.setGender(getResources().getString(R.string.ma_others_gender));
                    }

                    ArrayList<String> preferences = new ArrayList<>();
                    if(chDonut.isChecked()){
                        preferences.add(chDonut.getText().toString());
                    }else{
                        preferences.add("-");
                    }

                    if(chPizza.isChecked()){
                        preferences.add(chPizza.getText().toString());
                    }else{
                        preferences.add("-");
                    }

                    if(chCake.isChecked()){
                        preferences.add(chCake.getText().toString());
                    }else{
                        preferences.add("-");
                    }

                    if(chToast.isChecked()){
                        preferences.add(chToast.getText().toString());
                    }else{
                        preferences.add("-");
                    }

                    p.setPreferences(preferences);

                    clean();

                    Toast.makeText(getBaseContext(), p.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void clean(){
        etName.setText(null);
        etAge.setText(null);
        rgGender.clearCheck();
        chDonut.setChecked(false);
        chPizza.setChecked(false);
        chCake.setChecked(false);
        chToast.setChecked(false);
    }
}