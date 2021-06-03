package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class Settings extends AppCompatActivity {

    private static final String nameSharedPreference = "LOGIN";

    private static final String appTheme = "Theme_CaculatorCastom";
    private static final int myCoolCodeStyle = 0;
    private static final int appThemeLightCodeStyle = 1;
    private static final int appThemeCodeStyle = 2;
    private static final int appThemeDarkCodeStyle = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme());
        setContentView(R.layout.activity_settings);
        initThemeChooser();

        findViewById(R.id.buttonBack).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonMyCoolStyle), myCoolCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialDark), appThemeDarkCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLight), appThemeLightCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLightDarkAction), appThemeCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(myCoolCodeStyle))).setChecked(true);
    }


    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(v -> {
            // сохраним настройки
            setAppTheme(codeStyle);
            // пересоздадим активити, чтобы тема применилась
            recreate();
        });
    }

    private int getAppTheme() {
        return codeStyleToStyleId(getCodeStyle(R.style.black));
    }

    // Чтение настроек, параметр «тема»
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
}