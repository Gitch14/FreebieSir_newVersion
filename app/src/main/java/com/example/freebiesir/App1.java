package com.example.freebiesir;

import android.app.Application;

public class App1 extends Application {
    public static boolean isActive1 = false;

    public static boolean getInstance(boolean b) {
        return isActive1;

    }

    public static boolean getInstance() {
        return false;
    }

    public boolean getActive(boolean b) {
        return isActive1;
    }

    public void setisActive(boolean _isActive1) {
        this.isActive1= _isActive1;
    }

}
