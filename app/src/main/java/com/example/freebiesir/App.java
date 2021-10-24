package com.example.freebiesir;

import android.app.Application;

public class App extends Application {
    public static boolean isActive = false;

    public static boolean getInstance(boolean b) {
        return isActive;

    }

    public static boolean getInstance() {
        return false;
    }

    public boolean getActive(boolean b) {
        return isActive;
    }

    public void setisActive(boolean _isActive) {
        this.isActive= _isActive;
    }

}
