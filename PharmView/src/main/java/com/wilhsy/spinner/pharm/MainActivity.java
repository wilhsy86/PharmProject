package com.wilhsy.spinner.pharm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wilhsy.spinner.WheelPicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity implements  WheelPicker.OnItemSelectedListener ,   View.OnClickListener {
    private static final String TAG = WheelPicker.class.getSimpleName();
    private WheelPicker wheelLeft;
    private WheelPicker wheelCenter;
    private WheelPicker wheelRight;
    private  int counter = 0;
    private int getValueButtonItemIndex;
    private Button getValueButton;
    private Button resultButton;
    private Button showLegendButton;
    private Button skipQuestionButton;
    private Button showAnswerButton;
    private Button goHomeButton;
    private TextView legend;
    private TextView genericName;
    private String genericAttr;
    private String brandAttr;
    private String pharmAttr;
    private String theraAttr;
    private String colorAttr;
    private boolean[] used = new boolean[304];
    private int randomNum;
    private ArrayList<String> drugList = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.wilhsy.spinner.pharm.R.layout.ac_main);
        drugList = getIntent().getExtras().getStringArrayList("drugList");

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.title_Bar));
        }

        wheelLeft = (WheelPicker) findViewById(com.wilhsy.spinner.pharm.R.id.main_wheel_left);
        wheelLeft.setOnItemSelectedListener(this);
        wheelCenter = (WheelPicker) findViewById(com.wilhsy.spinner.pharm.R.id.main_wheel_center);
        wheelCenter.setOnItemSelectedListener(this);
        wheelRight = (WheelPicker) findViewById(com.wilhsy.spinner.pharm.R.id.main_wheel_right);
        wheelRight.setOnItemSelectedListener(this);

        showLegendButton = (Button) findViewById(com.wilhsy.spinner.pharm.R.id.show_legend_btn);
        showLegendButton.setOnClickListener(this);

        goHomeButton = (Button) findViewById(R.id.go_home_btn);
        goHomeButton.setOnClickListener(this);

        showAnswerButton = (Button) findViewById(com.wilhsy.spinner.pharm.R.id.show_answer_btn);
        showAnswerButton.setOnClickListener(this);

        getValueButton = (Button) findViewById(com.wilhsy.spinner.pharm.R.id.get_value_btn);
        getValueButton.setOnClickListener(this);
        getValueButton.setText("Check Answer");

        skipQuestionButton = (Button) findViewById(com.wilhsy.spinner.pharm.R.id.skip_question_btn);
        skipQuestionButton.setOnClickListener(this);

        resultButton = (Button) findViewById(com.wilhsy.spinner.pharm.R.id.result_btn);
        resultButton.setVisibility(View.INVISIBLE);
        resultButton.setClickable(false);

        genericName = (TextView) findViewById(com.wilhsy.spinner.pharm.R.id.generic_name);
        genericName = (TextView) findViewById(com.wilhsy.spinner.pharm.R.id.generic_name);

        legend = (TextView) findViewById(com.wilhsy.spinner.pharm.R.id.Cardiovascular);
        legend.setVisibility(View.INVISIBLE);
        legend.setText(Html.fromHtml("<font color=\"#EE0000\">" + "Cardiovascular   " + "</font>" + "<font color=\"#0000FF\">" + "Pulmonary   " + "</font>" + "<font color=\"#ffff00\">" + "Renal   " + "</font>" +
                "<font color=\"#A52A2A\">" + "Gastrointestinal   " + "</font>" + "<font color=\"#FFFFFF\">" + "Skin   " + "</font>" + "<font color=\"#800080\">" + "Endocrine   " + "</font>" +  "<br>" +
                "<font color=\"#FFA500\">" + "Neurology   " + "</font>" + "<font color=\"#008000\">" + "Ear Nose &amp; Throat   " + "</font>" + "<font color=\"#FFC0CB\">" + "Pain   " + "</font>" +
                "<font color=\"#808080\">" + "Psych   " + "</font>" + "<font color=\"#800000\">" + "Musculoskeletal   " + "</font>" + "<font color=\"#00FF00\">" + "Antibiotics   " + "</font>"));

        questionManager();
    }

    public void questionManager(){
        genericName.setTextColor(Color.BLACK);
        skipQuestionButton.setVisibility(View.VISIBLE);
        showAnswerButton.setVisibility(View.VISIBLE);

        Random rand = new Random();
        randomNum = rand.nextInt(drugList.size());
        System.out.println("Random Number is: " + randomNum);
        if (used[randomNum] == false){
            String temp = drugList.get(randomNum);
            used[randomNum] = true;
            System.out.println("!!!!!!!!!!!!!!!! " + temp);

            String[] columns = temp.split("\t");
            String genericAttr = columns[0];
            brandAttr = columns[1];
            pharmAttr = columns[2];
            theraAttr = columns[3];
            colorAttr = columns[4];

            System.out.println(" Values are " + genericAttr + "  " + brandAttr + "  " + pharmAttr + "  " + theraAttr + "  " + colorAttr);
            genericName.setText(genericAttr);
        }
    }

    private void getSpinnerValue() {
        getValueButtonItemIndex = (int) (Math.random() * wheelCenter.getData().size());
    }


    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        resultButton.setVisibility(View.INVISIBLE);
        //genericName.setText("New Question");
        String text = "";
        switch (picker.getId()) {
            case com.wilhsy.spinner.pharm.R.id.main_wheel_left:
                text = "Left:";
                break;
            case com.wilhsy.spinner.pharm.R.id.main_wheel_center:
                text = "Center:";
                break;
            case com.wilhsy.spinner.pharm.R.id.main_wheel_right:
                text = "Right:";
                break;
        }
        //Toast.makeText(this, text + String.valueOf(data), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case com.wilhsy.spinner.pharm.R.id.get_value_btn:
                String checkAnswer = "Check Answer";
                String nextQuestion = "Next Question";

                if (checkAnswer.equals(getValueButton.getText())){
                    //legend.setVisibility(View.VISIBLE);

                    boolean selectedBrand = false;
                    boolean selectedPharm = false;
                    boolean selectedThera = false;

                    counter++;
                    String text = "Third Try! (Display Hint Here)";
                    if (counter == 3) {
                        if (colorAttr.equals("Red")) {
                            genericName.setTextColor(Color.parseColor("#EE0000"));
                        }
                        else if (colorAttr.equals("Lime")) {
                            genericName.setTextColor(Color.parseColor("#00FF00"));
                        }
                        else if (colorAttr.equals("Orange")) {
                            genericName.setTextColor(Color.parseColor("#FFA500"));
                        }
                        else if (colorAttr.equals("Brown")) {
                            genericName.setTextColor(Color.parseColor("#A52A2A"));
                        }
                        else if (colorAttr.equals("Blue")) {
                            genericName.setTextColor(Color.parseColor("#0000FF"));
                        }
                        else if (colorAttr.equals("Grey")) {
                            genericName.setTextColor(Color.parseColor("#808080"));
                        }
                        else if (colorAttr.equals("Yellow")) {
                            genericName.setTextColor(Color.parseColor("#ffff00"));
                        }
                        else if (colorAttr.equals("Green")) {
                            genericName.setTextColor(Color.parseColor("#008000"));
                        }
                        else if (colorAttr.equals("Pink")) {
                            genericName.setTextColor(Color.parseColor("#FFC0CB"));
                        }
                        else if (colorAttr.equals("Purple")) {
                            genericName.setTextColor(Color.parseColor("#800080"));
                        }
                        else if (colorAttr.equals("Maroon")) {
                            genericName.setTextColor(Color.parseColor("#800000"));
                        }
                        else if (colorAttr.equals("White")) {
                            genericName.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        else if (colorAttr.equals("Black")) {
                            genericName.setTextColor(Color.BLACK);
                        }
                        Toast.makeText(this, "Hint: Color = Class", Toast.LENGTH_SHORT).show();
                    }

                    if ( counter >= 5){
                        resultButton.setVisibility(View.INVISIBLE);
                        questionManager();
                        counter = 0;
                        getValueButton.setText("Check Answer");
                        Toast.makeText(this, "We'll come back to that one later.. ", Toast.LENGTH_SHORT).show();

                        break;
                    }

                    if (wheelLeft.getData().get(wheelLeft.getCurrentItemPosition()).equals(brandAttr) ){
                        selectedBrand = true;
                    }
                    if (wheelCenter.getData().get(wheelCenter.getCurrentItemPosition()).equals(pharmAttr) ){
                        selectedPharm = true;
                    }
                    if (wheelRight.getData().get(wheelRight.getCurrentItemPosition()).equals(theraAttr)){
                        selectedThera = true;
                    }

                    if (selectedBrand && selectedPharm && selectedThera){
                        resultButton.setText("Correct! Select next to proceed");
                        getValueButton.setText("Next Question");
                        counter = 0;
                        used[randomNum] = true;
                    }
                    else {
                        String textOutput = "Incorrect! Check ";
                        List<String> incorrectAttributes = new ArrayList<String>();

                        if (!selectedThera) {
                            incorrectAttributes.add("Therapeutic Use");

                        }
                        if (!selectedPharm) {
                            incorrectAttributes.add("Pharmacological Class");
                        }
                        if (!selectedBrand){
                            incorrectAttributes.add("Brand Name");
                        }
                        for (int s = 0; s < incorrectAttributes.size(); s++) {
                            if (s >= 1 && s < incorrectAttributes.size() - 1) textOutput = textOutput + " , ";
                            else if (s != 0) textOutput = textOutput + " & ";
                            textOutput = textOutput + incorrectAttributes.get(s);
                        }
                        resultButton.setText(textOutput);
                    }


                    resultButton.setVisibility(View.VISIBLE);
                    break;
                }
                else if (nextQuestion.equals(getValueButton.getText())) {
                    resultButton.setVisibility(View.INVISIBLE);
                    questionManager();
                    used[randomNum] = false;
                    counter = 0;
                    getValueButton.setText("Check Answer");
                    break;
                }

            case com.wilhsy.spinner.pharm.R.id.go_home_btn:
                Intent intent = new Intent(MainActivity.this, PreviewActivity.class);
                startActivity(intent);
                break;

            case com.wilhsy.spinner.pharm.R.id.show_answer_btn:

                resultButton.setText("Solution- Brand: " + brandAttr + "   Pharm: " + pharmAttr + "   Thera: " + theraAttr);
                resultButton.setVisibility(View.VISIBLE);
                getValueButton.setText("Next Question");
                skipQuestionButton.setVisibility(View.INVISIBLE);
                showAnswerButton.setVisibility(View.INVISIBLE);
                //Toast.makeText(this, "Select \"Next Question when ready to proceed\". ", Toast.LENGTH_LONG).show();

//                wheelCenter.setSelectedItemPosition(wheelCenter.getData().get(gotoBtnItemIndex));
//                wheelRight.setSelectedItemPosition(wheelRight.getData().get(gotoBtnItemIndex));
//                wheelLeft.setSelectedItemPosition(wheelLeft.getData().get(gotoBtnItemIndex));
                break;

            case com.wilhsy.spinner.pharm.R.id.skip_question_btn:
                resultButton.setVisibility(View.INVISIBLE);
                questionManager();
                used[randomNum] = false;
                counter = 0;
                break;


            case com.wilhsy.spinner.pharm.R.id.show_legend_btn:
                String showLegend = "Show Legend";
                String hideLegend = "Hide Legend";

                if (showLegend.equals(showLegendButton.getText())){
                    legend.setVisibility(View.VISIBLE);
                    showLegendButton.setText("Hide Legend");
                }
                else if (hideLegend.equals(showLegendButton.getText())) {
                    legend.setVisibility(View.INVISIBLE);
                    showLegendButton.setText("Show Legend");
                }
                break;
        }
    }
}
