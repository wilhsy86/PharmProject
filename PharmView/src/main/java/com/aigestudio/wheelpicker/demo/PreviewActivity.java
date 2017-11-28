package com.aigestudio.wheelpicker.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aigestudio.wheelpicker.WheelPicker;
import com.aigestudio.wheelpicker.WheelPickerLeft;
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
    private Integer getValueButtonItemIndex;

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
        getValueButton.setOnClickListener(this);
        getValueButton.setText("Check Answer");
        resultButton.setVisibility(View.INVISIBLE);


    }

    private void getSpinnerValue() {
        getValueButtonItemIndex = (int) (Math.random() * wheelCenter.getData().size());

    }
    int counter = 0;
    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
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
    public void onClick(View v) {
        counter++;
        String text = "Third Try! (Display Hint Here)";
        if (counter == 3){
            Toast.makeText(this, text , Toast.LENGTH_SHORT).show();
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

    }
}