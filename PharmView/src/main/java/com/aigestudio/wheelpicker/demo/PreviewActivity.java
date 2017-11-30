package com.aigestudio.wheelpicker.demo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.Timer;
import java.util.TimerTask;
//import com.aigestudio.wheelpicker.WheelPickerRight;

/**
 * @author AigeStudio 2015-12-06
 * @author AigeStudio 2016-07-08
 */
public class PreviewActivity extends Activity implements  WheelPicker.OnItemSelectedListener ,   View.OnClickListener {

    private WheelPicker wheelLeft;
    private WheelPicker wheelCenter;
    private WheelPicker wheelRight;

    private Button getValueButton;
    private Button resultButton;
    private Button showLegendButton;
    private Integer getValueButtonItemIndex;
    private TextView legend;
    private TextView genericName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_preview);
        wheelLeft = (WheelPicker) findViewById(R.id.main_wheel_left);
        wheelLeft.setOnItemSelectedListener(this);
        wheelCenter = (WheelPicker) findViewById(R.id.main_wheel_center);
        wheelCenter.setOnItemSelectedListener(this);
        wheelRight = (WheelPicker) findViewById(R.id.main_wheel_right);
        wheelRight.setOnItemSelectedListener(this);

//        getValueButton = (Button) findViewById(R.id.get_value_btn);
//        getValueButton.setOnClickListener(this);
//        getValueButton.setText("Selected Value is");




        getValueButton = (Button) findViewById(R.id.get_value_btn);
        resultButton = (Button) findViewById(R.id.result_btn);
        showLegendButton = (Button) findViewById(R.id.show_legend_btn);
        showLegendButton.setOnClickListener(this);
        getValueButton.setOnClickListener(this);
        getValueButton.setText("Check Answer");
        resultButton.setVisibility(View.INVISIBLE);

        legend = (TextView) findViewById(R.id.Cardiovascular);
        genericName = (TextView) findViewById(R.id.generic_name);
//
        legend.setVisibility(View.INVISIBLE);
        legend.setText(Html.fromHtml("<font color=\"#EE0000\">" + "Cardiovascular   " + "</font>" + "<font color=\"#0000FF\">" + "Pulmonary   " + "</font>" + "<font color=\"#ffff00\">" + "Renal   " + "</font>" +
                                      "<font color=\"#A52A2A\">" + "Gastrointestinal   " + "</font>" + "<font color=\"#FFFFFF\">" + "Skin   " + "</font>" + "<font color=\"#EE0000\">" + "Endocrine   " + "</font>" +  "<br>" +
                                      "<font color=\"#FFA500\">" + "Neurology   " + "</font>" + "<font color=\"#008000\">" + "Ear Nose &amp; Throat   " + "</font>" + "<font color=\"#FFC0CB\">" + "Pain   " + "</font>" +
                                      "<font color=\"#808080\">" + "Psych   " + "</font>" + "<font color=\"#800000\">" + "Musculoskeletal   " + "</font>" + "<font color=\"#00FF00\">" + "Antibiotics   " + "</font>"));


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

    private void getSpinnerValue() {
        getValueButtonItemIndex = (int) (Math.random() * wheelCenter.getData().size());
    }
    int counter = 0;
    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        resultButton.setVisibility(View.INVISIBLE);
        genericName.setText("New Question");
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
        //Toast.makeText(this, text + String.valueOf(data), Toast.LENGTH_SHORT).show();

//        Toast toast = Toast.makeText(this, resId, Toast.LENGTH_SHORT);
//        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
//        v.setTextColor(Color.RED);
//        toast.show();
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