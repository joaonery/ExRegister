package com.joaonery.exregister.model;

import android.content.Context;

import com.joaonery.exregister.R;

import java.util.ArrayList;

/**
 * @author João Nery
 * @since 31/07/2018
 * @version 1.0
 */
public class Person {
    private String name;
    private int age;
    private String gender;
    private ArrayList<String> preferences;
    private Context context;

    public Person(Context context) {
        this.context = context;
    }

    public Person(String name, int age, String gender, ArrayList<String> preferences) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<String> preferences) {
        this.preferences = preferences;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String toString() {
        String x = "";

        for(int i = 0; i < preferences.size(); i++){
            x += "\n" + preferences.get(i);
        }
        return  context.getResources().getString(R.string.ma_et_name) + ": " + name + "\n" +
                context.getResources().getString(R.string.ma_et_age) + ": " + age + "\n" +
                context.getResources().getString(R.string.ma_tv_gender) + ": " + gender + "\n\n" +
                context.getResources().getString(R.string.ma_tv_preferences) + ": " + x;
    }
}