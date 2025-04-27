package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private StringBuilder currentInput = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        if (savedInstanceState != null) {
            currentInput.append(savedInstanceState.getString("input"));
            display.setText(currentInput.toString());
        }


        setupButtons();
    }

    private void setupButtons() {
        int[] buttonIds = {
                R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9,
                R.id.button0, R.id.button_add, R.id.button_subtract,
                R.id.button_multiply, R.id.button_divide, R.id.button_clear};

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleInput(((Button) v).getText().toString());
                }
            });
        }
    }

    private void handleInput(String input) {
        if (input.equals("C")) {
            currentInput.setLength(0); 
        } else {
            currentInput.append(input); // Добавление нажатой цифры или знака.
        }
        display.setText(currentInput.toString()); // Обновление дисплея.
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("input", currentInput.toString()); // Сохранение состояния ввода.
    }
}