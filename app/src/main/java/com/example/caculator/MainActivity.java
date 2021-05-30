package com.example.caculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.caculator.BaseActivity.appThemeCodeStyle;
import static com.example.caculator.BaseActivity.appThemeDarkCodeStyle;
import static com.example.caculator.BaseActivity.appThemeLightCodeStyle;

public class MainActivity extends AppCompatActivity {

    private static final String nameSharedPreference = "LOGIN";
    private static final String appTheme = "Theme_CaculatorCastom";


    private SaveData saveData;
    String textSaveData;

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAddition, btnSubtraction, btnMultiply, btnDivision, btnSign, btnEqual, btnClear, btnClearAll, btnDot, btnSettings;
    TextView textInput, textOutput;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(getAppTheme(R.style.black));

        setContentView(R.layout.activity_main);
        saveData = new SaveData();

        findViewById(R.id.button_settings).setOnClickListener(v -> {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        });

        initView();
        buttonHandler();

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        saveData = (SaveData) savedInstanceState.getSerializable("SAVE_DATA");
        textSaveData = saveData.getText();
        textInput.setText(textSaveData);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        textSaveData = textInput.getText().toString();
        saveData.setChangeText(textSaveData);
        outState.putSerializable("SAVE_DATA", saveData);
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(nameSharedPreference, MODE_PRIVATE);
        //Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(appTheme, codeStyle);
    }

    // Сохранение настроек
    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(nameSharedPreference, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(appTheme, codeStyle);
        editor.apply();
    }
    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case appThemeCodeStyle:
                return R.style.Theme_CalculatorCastom;
            case appThemeLightCodeStyle:
                return R.style.AppThemeLight;
            case appThemeDarkCodeStyle:
                return R.style.AppThemeDark;
            default:
                return R.style.black;
        }
    }

    public void initView() {
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnDot = findViewById(R.id.button_dot);

        btnAddition = findViewById(R.id.button_addition);
        btnSubtraction = findViewById(R.id.button_subtraction);
        btnDivision = findViewById(R.id.button_division);
        btnMultiply = findViewById(R.id.button_multiplication);
        btnSign = findViewById(R.id.button_sign);

        btnEqual = findViewById(R.id.button_equals);

        btnClear = findViewById(R.id.button_clear);
        btnClearAll = findViewById(R.id.button_clear_all);

        textInput = findViewById(R.id.textInput);
        textOutput = findViewById(R.id.textOutput);
        btnSettings = findViewById(R.id.button_settings);
    }

    public void buttonHandler() {

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutput.setText(" ");
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.setText("");
                textOutput.setText("");
            }
        });


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "6");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "9");
            }
        });

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "+");
            }
        });

        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "×");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "÷");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + ".");
            }
        });

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "+/-");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textInput.getText().toString();
                textInput.setText(process + "=");
            }
        });
    }
}