package com.laba.lr223;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    boolean recipes[] = new boolean[4];
    boolean selfOrDeliv;
    boolean isCold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onSwitchClicked(View view){
        boolean on = ((Switch) view).isChecked();
        ImageView image = (ImageView) findViewById(R.id.imageView);
        if(on) {
            image.setImageResource(R.drawable.hot_coffee);
            ((Switch) view).setText("Горячий");
            isCold = false;
        }
        else {
            image.setImageResource(R.drawable.cold_coffee);
            ((Switch) view).setText("Холодный");
            isCold = true;
        }
    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox_milk:
                if (checked) {
                    recipes[0] = true;
                } else recipes[0] = false;
                break;
            case R.id.checkBox_sugar:
                if (checked) {
                    recipes[1] = true;
                } else recipes[1] = false;
                break;
            case R.id.checkBox_slivki:
                if (checked) {
                    recipes[2] = true;
                } else recipes[2] = false;
                break;
            case R.id.checkBox_sirop:
                if (checked) {
                    recipes[3] = true;
                } else recipes[3] = false;
                break;
        }
    }
    public void onRadioButtonClicked(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radioSelf:
                selfOrDeliv = false;
                break;
            case R.id.radioDeliv:
                selfOrDeliv = true;
                break;
        }
    }
    
    public void onOrderButtonClicked(View view) {

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra("isCold", isCold);
        intent.putExtra("ingredients", recipes);
        intent.putExtra("selfOrDeliv", selfOrDeliv);
        startActivity(intent);
    }


}