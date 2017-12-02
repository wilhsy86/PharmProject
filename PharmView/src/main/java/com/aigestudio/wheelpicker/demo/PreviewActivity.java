package com.aigestudio.wheelpicker.demo;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aigestudio.wheelpicker.WheelPicker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class PreviewActivity extends Activity implements  WheelPicker.OnItemSelectedListener ,   View.OnClickListener {
    private static final String TAG = WheelPicker.class.getSimpleName();
    private WheelPicker wheelLeft;
    private WheelPicker wheelCenter;
    private WheelPicker wheelRight;

    private Button getValueButton;
    private Button resultButton;
    private Button showLegendButton;
    private Button nextQuestion;
    private Integer getValueButtonItemIndex;
    private TextView legend;
    private TextView genericName;
    private String genericAttr;
    private String brandAttr;
    private String pharmAttr;
    private String theraAttr;
    private String colorAttr;
    private boolean[] used = new boolean[304];



    private ArrayList<String> drugList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        try {
//            //new QuestionManager();
//            Log.i(TAG, "Question Manager initiated!!!!!!!!!!!!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_preview);
        genericName = (TextView) findViewById(R.id.generic_name);
        wheelLeft = (WheelPicker) findViewById(R.id.main_wheel_left);
        wheelLeft.setOnItemSelectedListener(this);
        wheelCenter = (WheelPicker) findViewById(R.id.main_wheel_center);
        wheelCenter.setOnItemSelectedListener(this);
        wheelRight = (WheelPicker) findViewById(R.id.main_wheel_right);
        wheelRight.setOnItemSelectedListener(this);
        getValueButton = (Button) findViewById(R.id.get_value_btn);
        resultButton = (Button) findViewById(R.id.result_btn);
        showLegendButton = (Button) findViewById(R.id.show_legend_btn);
        showLegendButton.setOnClickListener(this);
        getValueButton.setOnClickListener(this);
        getValueButton.setText("Check Answer");
        resultButton.setVisibility(View.INVISIBLE);
        legend = (TextView) findViewById(R.id.Cardiovascular);
        genericName = (TextView) findViewById(R.id.generic_name);//
        legend.setVisibility(View.INVISIBLE);
        legend.setText(Html.fromHtml("<font color=\"#EE0000\">" + "Cardiovascular   " + "</font>" + "<font color=\"#0000FF\">" + "Pulmonary   " + "</font>" + "<font color=\"#ffff00\">" + "Renal   " + "</font>" +
                "<font color=\"#A52A2A\">" + "Gastrointestinal   " + "</font>" + "<font color=\"#FFFFFF\">" + "Skin   " + "</font>" + "<font color=\"#EE0000\">" + "Endocrine   " + "</font>" +  "<br>" +
                "<font color=\"#FFA500\">" + "Neurology   " + "</font>" + "<font color=\"#008000\">" + "Ear Nose &amp; Throat   " + "</font>" + "<font color=\"#FFC0CB\">" + "Pain   " + "</font>" +
                "<font color=\"#808080\">" + "Psych   " + "</font>" + "<font color=\"#800000\">" + "Musculoskeletal   " + "</font>" + "<font color=\"#00FF00\">" + "Antibiotics   " + "</font>"));

        {
//            try {
//                new QuestionManager();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        getValueButton = (Button) findViewById(R.id.get_value_btn);
        getValueButton.setOnClickListener(this);
        getValueButton.setText("Selected Value is");

        drugList = getDrugs();
        questionManager();



//        AssetManager assetManager = getAssets();
//        // To load text file
//        InputStream input;
//        try {
//            input = assetManager.open("drugs.txt");
//            reader = new BufferedReader(new InputStreamReader(input));
//            while (input != null){
//                line = reader.readLine();
//                System.out.println(line);
////            int size = input.available();
////            byte[] buffer = new byte[size];
////            input.read(buffer);
////            input.close();
//
//                // byte buffer into a string
//                String text = new String(line);
//            }
//
//
//            //genericName.setText(text);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }




    }

    private void showLegendButton() {
        new Thread(new Runnable(){
            public void run(){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                legend.setVisibility(View.VISIBLE);
            }
        }).run();

            //t.setVisibility(View.INVISIBLE);
    }

    public ArrayList<String> getDrugs(){
        ArrayList<String> drugList = new ArrayList<String>();
        String questionGeneric = "";

        try {
            AssetManager assetManager = getAssets();
            // To load text file
            InputStream input = assetManager.open("drugs.txt");

            if (input != null){
                //prepare file for reading
                InputStreamReader inputreader = new InputStreamReader(input);
                BufferedReader reader = new BufferedReader(inputreader);
                String line;

                do {
                    line = reader.readLine();
                    if (line != null){
                        //System.out.println(line);
                        drugList.add(line);
                    }

                    //questionGeneric = line;
                } while (line != null);
                inputreader.close();
                reader.close();

            }
            System.out.println("!!!!!!!!!!!!!!!!!!!Drug List Size is: " + drugList.size());
            //System.out.println(drugList.get(303));
            //genericName.setText(drugList.get(150));
//            for (String S : drugList ) {
//                //System.out.println(S);
//
//            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return drugList;
    }

    public void questionManager(){

        //System.out.println("WWWWWWWWWRRRRRRRRRRR " + drugList.get(303));


        Random rand = new Random();
        int randomNum = rand.nextInt((drugList.size() - 0) + 1) + 0;
        System.out.println("Random Number is: " + randomNum);
        if (used[randomNum] == false){
            String temp = drugList.get(randomNum);
            used[randomNum] = true;
            System.out.println("!!!!!!!!!!!!!!!! " + temp);

            String[] columns = temp.split("\t");
            String generic = columns[0];
            String brand = columns[1];
            String pharma = columns[2];
            String thera = columns[3];
            String color = columns[4];

            System.out.println(" Values are " + generic + "  " + brand + "  " + pharma + "  " + thera + "  " + color);
            genericName.setText(generic);
        }
    }

    public void checkAnswer(){

    }

    private void getSpinnerValue() {
        getValueButtonItemIndex = (int) (Math.random() * wheelCenter.getData().size());
    }
    int counter = 0;
    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        resultButton.setVisibility(View.INVISIBLE);
        //genericName.setText("New Question");
        String text = "";
        switch (picker.getId()) {
            case R.id.main_wheel_left:
                text = "Left:";
                break;
            case R.id.main_wheel_center:
                text = "Center:";
                break;
            case R.id.main_wheel_right:
                text = "Right:";
                break;
        }
        Toast.makeText(this, text + String.valueOf(data), Toast.LENGTH_SHORT).show();


    }








    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.get_value_btn:

                counter++;
                String text = "Third Try! (Display Hint Here)";
                if (counter == 3){
//            View view;
//            TextView text1;
//            Toast toast;
//            toast.makeText(this, resId, Toast.LENGTH_SHORT);
//            view = toast.getView();
//            text1 = (TextView) view.findViewById(android.R.id.message);
//            text1.setTextColor(getResources().getColor(R.color.black));
//            text1.setShadowLayer(0,0,0,0);
//            view.setBackgroundResource(R.color.white);
//            toast.show();
//            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
//            Toast.makeText(this, text , Toast.LENGTH_SHORT).show();
                    counter = 0;
                }
                Integer temp = wheelCenter.getCurrentItemPosition();
                getSpinnerValue();
                resultButton = (Button) findViewById(R.id.result_btn);
                getSpinnerValue();
                resultButton.setOnClickListener(this);
                resultButton.setText("Selected Values are " + wheelLeft.getData().get(wheelLeft.getCurrentItemPosition()) + " , " + wheelCenter.getData().get(temp)
                        + " , " + wheelRight.getData().get(wheelRight.getCurrentItemPosition()));
                resultButton.setVisibility(View.VISIBLE);
                break;

            case R.id.result_btn:
                //DO something
                break;


            case R.id.show_legend_btn:
                String showLegend = "Show Legend";
                String hideLegend = "Hide Legend";
                String legendText = showLegendButton.getText().toString();


                if (showLegend.equals(showLegendButton.getText())){
                    legend.setVisibility(View.VISIBLE);
                    showLegendButton.setText("Hide Legend");
                }
                else if (hideLegend.equals(showLegendButton.getText())) {
                    legend.setVisibility(View.INVISIBLE);
                    showLegendButton.setText("Show Legend");
                }

//                new Thread(new Runnable(){
//                    public void run(){
//                        try {
//                            Thread.sleep(5000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        t.setVisibility(View.INVISIBLE);
//                    }
//                }).run();

                    //showLegendButton();
                    //t.setVisibility(View.INVISIBLE);
                break;
        }
    }
}