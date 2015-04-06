package com.wwu.jimmy.jamescollins_hw1_tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText myEditField = (EditText) findViewById(R.id.billTotal);


        final Button button = (Button) findViewById(R.id.calculateButton);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {
                    String mealprice = myEditField.getText().toString();
                    String answer = "";
                    //if (mealprice.indexOf("$") == -1) {
                    //    mealprice = "$" + mealprice;
                    //}
                    NumberFormat nf = java.text.NumberFormat.getCurrencyInstance();
                    if (nf == null) {
                        Log.i("", "NumberFormat is null");
                    }
                    float fmp = nf.parse(mealprice).floatValue();
                    fmp *= 2;
                    //Log.i("", "Total:" + fmp);
                    //answer = "Full Price:" + nf.format(fmp);
                    //answerfield.setText(answer);
                } catch (java.text.ParseException pe) {
                    //Log.i("", "Parse exception caught");
                    finalAmount.setText("Failed to parse amount?");
                } catch (Exception e) {
                    Log.e("", "Failed to Calculate Tip:" + e.getMessage());
                    e.printStackTrace();
                    answerfield.setText(e.getMessage());
                }
            }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


