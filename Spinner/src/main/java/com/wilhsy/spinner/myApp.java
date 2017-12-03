package com.wilhsy.spinner;
import android.app.Application;

/**
 * Created by WiLhS on 11/25/2017.
 */

public class myApp extends Application {
    private static int locationIndex = 0;

    public myApp() {
        this.setIndex(0);
        System.out.println("myApp initialized!");
    }

    public static int getindex(){
        System.out.println("myApp index recieved! index is: " + locationIndex);
        return locationIndex;

    }

    public static void setIndex(int index){
        locationIndex = index;
        System.out.println("myApp index set!");
    }
}
