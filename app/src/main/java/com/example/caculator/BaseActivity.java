package com.example.caculator;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    // Имя настроек
    private static final String nameSharedPreference = "LOGIN";

    // Имя параметра в настройках
    private static final String appTheme = "Theme_CaculatorCastom";

    protected static final int appThemeLightCodeStyle = 1;
    protected static final int appThemeCodeStyle = 2;
    protected static final int appThemeDarkCodeStyle = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Устанавливать тему надо только до установки макета активити
        setTheme(getAppTheme());
    }

    private int getAppTheme() {
        return codeStyleToStyleId(getCodeStyle());
    }

    // Чтение настроек, параметр «тема»
    protected int getCodeStyle(){
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(nameSharedPreference, MODE_PRIVATE);
        //Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(appTheme, R.style.black);
    }

    private int codeStyleToStyleId(int codeStyle){
        switch(codeStyle){
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
