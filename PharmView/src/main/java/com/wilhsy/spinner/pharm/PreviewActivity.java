package com.wilhsy.spinner.pharm;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PreviewActivity extends Activity implements  View.OnClickListener {

    private CheckBox chkClassCardio, chkClassPulmonary, chkClassRenal, chkClassGastro, chkClassSkin, chkClassEndocrine, chkClassNeur, chkClassENT, chkClassPain, chkClassPsych, chkClassMS, chkClassAntiBiotic;

    private Button startPractice;
    private Button selectAll;
    private Button clearAll;

    public static ArrayList<String> drugList = new ArrayList<>();
    private ArrayList<String> checkedItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_preview);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.title_Bar));
        }


        chkClassCardio = (CheckBox) findViewById(R.id.cardiovascular);
        chkClassPulmonary = (CheckBox) findViewById(R.id.Pulmonary);
        chkClassRenal = (CheckBox) findViewById(R.id.Renal);
        chkClassGastro = (CheckBox) findViewById(R.id.Gastrointestinal);
        chkClassSkin = (CheckBox) findViewById(R.id.Skin);
        chkClassEndocrine = (CheckBox) findViewById(R.id.Endocrine);
        chkClassNeur = (CheckBox) findViewById(R.id.Neurology);
        chkClassENT = (CheckBox) findViewById(R.id.ENT);
        chkClassPain = (CheckBox) findViewById(R.id.Pain);
        chkClassPsych = (CheckBox) findViewById(R.id.Psyche);
        chkClassMS = (CheckBox) findViewById(R.id.Musculoskelatal);
        chkClassAntiBiotic = (CheckBox) findViewById(R.id.Antibiotics);

        startPractice = (Button) findViewById(R.id.start_practice);
        startPractice.setOnClickListener(this);

        selectAll = (Button) findViewById(R.id.select_all);
        selectAll.setOnClickListener(this);

        clearAll = (Button) findViewById(R.id.clear_all);
        clearAll.setOnClickListener(this);
    }

    public ArrayList<String> getDrugs(){
        ArrayList<String> drugList = new ArrayList<>();
        drugList.clear();
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

                        for(int i =0; i < checkedItems.size(); i++)
                        {
                            if(line.contains(checkedItems.get(i)))
                            {
                                drugList.add(line);
                            }
                        }
                        //System.out.println(line);
                        //drugList.add(line);
                    }

                    //questionGeneric = line;
                } while (line != null);
                inputreader.close();
                reader.close();
            }
            System.out.println("!!!!!!!!!!!!!!!!!!!Drug List Size is: " + drugList.size());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return drugList;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.start_practice:

                checkedItems.clear();

                if(chkClassCardio.isChecked()){
                    checkedItems.add("Red");
                }
                if(chkClassPulmonary.isChecked()){
                    checkedItems.add("Blue");
                }
                if(chkClassRenal.isChecked()){
                    checkedItems.add("Yellow");
                }
                if(chkClassGastro.isChecked()){
                    checkedItems.add("Brown");
                }
                if(chkClassSkin.isChecked()){
                    checkedItems.add("White");
                }
                if(chkClassEndocrine.isChecked()){
                    checkedItems.add("Purple");
                }
                if(chkClassNeur.isChecked()){
                    checkedItems.add("Orange");
                }
                if(chkClassENT.isChecked()){
                    checkedItems.add("Green");
                }
                if(chkClassPain.isChecked()){
                    checkedItems.add("Pink");
                }
                if(chkClassPsych.isChecked()){
                    checkedItems.add("Grey");
                }
                if(chkClassMS.isChecked()){
                    checkedItems.add("Maroon");
                }
                if(chkClassAntiBiotic.isChecked()){
                    checkedItems.add("Lime");
                }
                if(checkedItems.size() > 0){
                    drugList = getDrugs();

                    Intent intent = new Intent(PreviewActivity.this, MainActivity.class);
                    intent.putStringArrayListExtra("drugList", drugList);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this, "You must select at least one drug class!", Toast.LENGTH_LONG).show();
                }
                break;


            case R.id.clear_all:
                chkClassAntiBiotic.setChecked(false);
                chkClassPsych.setChecked(false);
                chkClassPain.setChecked(false);
                chkClassENT.setChecked(false);
                chkClassNeur.setChecked(false);
                chkClassMS.setChecked(false);
                chkClassEndocrine.setChecked(false);
                chkClassSkin.setChecked(false);
                chkClassGastro.setChecked(false);
                chkClassRenal.setChecked(false);
                chkClassPulmonary.setChecked(false);
                chkClassCardio.setChecked(false);
                break;

            case R.id.select_all:
                chkClassAntiBiotic.setChecked(true);
                chkClassPsych.setChecked(true);
                chkClassPain.setChecked(true);
                chkClassENT.setChecked(true);
                chkClassNeur.setChecked(true);
                chkClassMS.setChecked(true);
                chkClassEndocrine.setChecked(true);
                chkClassSkin.setChecked(true);
                chkClassGastro.setChecked(true);
                chkClassRenal.setChecked(true);
                chkClassPulmonary.setChecked(true);
                chkClassCardio.setChecked(true);
                break;
        }
    }
}