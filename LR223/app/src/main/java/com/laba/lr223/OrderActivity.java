package com.laba.lr223;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();

        boolean meow = false;
        String text = "Вы заказали ";
        if(intent.getBooleanExtra("isCold", meow)) text += "холодный кофе ";
        else text += "горячий кофе ";
        boolean ing = false;
        boolean ingredients[] = intent.getBooleanArrayExtra("ingredients");
        for (boolean b : ingredients) {
            if (b) {ing = true;}}
        if(!ing) text += "без добавок";
        else text += "со следующими добавками: ";
        if (ingredients[0]) text += "молоко";
        if (ingredients[1]) text += ", сахар";
        if (ingredients[2]) text += ", сливки";
        if (ingredients[3]) text += ", сироп";
        text += ". Способ получения: ";
        boolean m = intent.getBooleanExtra("selfOrDeliv", meow);
        if (m) text += "доставка.";
            else text += "самовывоз.";
        final TextView orderInfoText = findViewById(R.id.orderInfo);
        orderInfoText.setText(text);
    }
}
