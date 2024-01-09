package dev.aakarsh.movie;

import org.json.JSONException;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by AS046134 on 14-05-2016.
 * Seasonal Intern, Cerner Corp
 */
public class PickerViewTest
{
    public static void main(String[] args) throws InterruptedException, JSONException, InvocationTargetException
    {
        new MoviePickerView().setVisible(true);
    }
}