//package com.wilhsy.spinner.pharm;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//import com.wilhsy.spinner.*;
//
////C:\Users\WiLhS\AndroidStudioProjects\ProjectPharm\PharmApp\src\main\java\com\aigestudio\wheelpicker\demo\PreviewActivity.java
//
//public static class PreviewActivity extends Activity implements  WheelPicker.OnItemSelectedListener ,   View.OnClickListener {
//
//    private WheelPicker wheelLeft;
//    private WheelPicker wheelCenter;
//    private WheelPicker wheelRight;
//
//
//
//    private TextView text;
//    private Button getValueButton;
//    private Button resultButton;
//    private Integer getValueButtonItemIndex;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.ac_preview);
//        wheelLeft = (WheelPicker) findViewById(R.id.main_wheel_left);
//        wheelLeft.setOnItemSelectedListener(this);
//        wheelCenter = (WheelPicker) findViewById(R.id.main_wheel_center);
//        wheelCenter.setOnItemSelectedListener(this);
//        wheelRight = (WheelPicker) findViewById(R.id.main_wheel_right);
//        wheelRight.setOnItemSelectedListener(this);
//
////        getValueButton = (Button) findViewById(R.id.get_value_btn);
////        getValueButton.setOnClickListener(this);
////        getValueButton.setText("Selected Value is");
//
//        getValueButton = (Button) findViewById(R.id.get_value_btn);
//        resultButton = (Button) findViewById(R.id.result_btn);
//        getValueButton.setOnClickListener(this);
//        getValueButton.setText("Check Answer");
//        resultButton.setVisibility(View.INVISIBLE);
//
//        text=(TextView)findViewById(R.id.Cardiovascular);
//        text.setText("Text");
//
//
//
//
//
////        String first = "This word is ";
////        String next = "<font color='#EE0000'>red</font>";
////        private TextView t;
////        t = (TextView) findViewById(R.id.Cardiovascular);
////        t.setText("<font color='#EE0000'>red</font>");
////        t.setText(Html.fromHtml("<font color='#EE0000'>red</font>"));
//
////        WebView webView = (WebView)findViewById(R.id.webView);
////        webView.getSettings().setJavaScriptEnabled(true);
////        webView.setWebChromeClient(new WebChromeClient());
////        webView.setBackgroundColor(0x00000000);
////        webView.loadUrl("file:///android_asset/index.html");
//
//
//
//
////        TextView textview1, textview2;
////        textView1 = (TextView) findViewById(R.id.Pulmonary);
////
////        textView2 = (TextView) findViewById(R.id.Pulmonary);
//
//
//
////        TextView = (TextView) findViewById(R.id.my_text_view);
////        htmltext = <font color='#EE0000'>red</font>;
////        Spanned sp = Html.fromHtml(htmltext);
////        myTextview.setText(sp);
//
//
//
//    }
//
//
//
//    private void getSpinnerValue() {
//        getValueButtonItemIndex = (int) (Math.random() * wheelCenter.getData().size());
//
//    }
//
//
//
//    @Override
//    public void onItemSelected(WheelPicker picker, Object data, int position) {
//        String text = "";
//        switch (picker.getId()) {
//            case R.id.main_wheel_left:
//                text = "Left:";
//                break;
//            case R.id.main_wheel_center:
//                text = "Center:";
//                break;
//            case R.id.main_wheel_right:
//                text = "Right:";
//                break;
//        }
//        Toast.makeText(this, text + String.valueOf(data), Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onClick(View v) {
//        Integer temp = wheelCenter.getCurrentItemPosition();
//        getSpinnerValue();
//        resultButton = (Button) findViewById(R.id.result_btn);
//        getSpinnerValue();
//        resultButton.setOnClickListener(this);
//        resultButton.setText("Selected Values are " + wheelLeft.getData().get(wheelLeft.getCurrentItemPosition()) + " , " + wheelCenter.getData().get(temp)
//                + " , " + wheelRight.getData().get(wheelRight.getCurrentItemPosition()));
//        resultButton.setVisibility(View.VISIBLE);
//
//    }
//}