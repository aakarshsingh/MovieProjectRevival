package dev.aakarsh.movie;

import org.json.JSONException;

import java.lang.reflect.InvocationTargetException;

public class PickerViewTest
{
    public static void main(String[] args) throws InterruptedException, JSONException, InvocationTargetException
    {
        new MoviePickerView().setVisible(true);
    }
}