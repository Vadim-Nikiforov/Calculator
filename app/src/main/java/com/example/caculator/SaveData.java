package com.example.caculator;

import java.io.Serializable;

public class SaveData implements Serializable {
    private String text;


    public SaveData() {
        text = "";
    }

    public String getText() {
        return text;
    }

    public void setChangeText(String text) {
        this.text = text;
    }
}
