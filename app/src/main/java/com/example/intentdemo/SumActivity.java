package com.example.intentdemo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SumActivity extends Activity {
    private double mInput1=0, mInput2=0;
    private boolean gotDataFromBundle = false;
    
    private String mMessageTemplate =
            "Sum of %.1f and %.1f is %.1f";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        setInputsFromExtras();
 //       setInputsFromUri();
        TextView sumView = (TextView)findViewById(R.id.sum_view);
        String message;
        if (gotDataFromBundle)
        	message = String.format(mMessageTemplate, mInput1, mInput2, (mInput1 + mInput2));
        else
        	message = getResources().getString(R.string.sum_activity_gotnothing);
        sumView.setText(message);
    }
    
    /** Sets the instance variables for input1 and input2 from the
     *  "extras" Bundle if it exists. If it exists, that means it was
     *  passed in from another Activity that invoked this one.
     */
    private void setInputsFromExtras() {
        Intent intent = getIntent();
        Bundle inputs = intent.getExtras();
        if (inputs != null) {
        	mInput1 = inputs.getDouble("input1",0);          
        	mInput2 = inputs.getDouble("input2",0);
        	gotDataFromBundle = true;
        }
    }
}
