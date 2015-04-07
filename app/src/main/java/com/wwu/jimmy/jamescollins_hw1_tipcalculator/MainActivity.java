// James Collins
// collinj8@students.wwu.edu
// CS412 - Mobile Device Programming
// Week 2 Project
//
// Project Description
// *******************
// Simple Tip Calculator
//
// Instructions
// *******************
// -Enter your Bill Amount
// -Select a Tip Percent Amount that
// you want to tip your waitor
// -Then press submit!
// -You will be presented with the Tip
// amount as well as the final bill
// amount to put on the check

package com.wwu.jimmy.jamescollins_hw1_tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Grab fields from user view (activity_main.xml)
        final EditText myEditField = (EditText) findViewById(R.id.billTotal);
        final TextView finalAmount = (TextView) findViewById(R.id.finalDisplay);
        final TextView taxAmount = (TextView) findViewById(R.id.taxDisplay);

        //Add Watcher for Button "Calculate"
        Button button = (Button) findViewById(R.id.calculateButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    //Get Meal Price From User
                    String mealprice = myEditField.getText().toString();
                    float floatingMealPrice = Float.parseFloat(mealprice);

                    //Find out which checkbox is checked and assign taxPercent
                    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                    int id = radioGroup.getCheckedRadioButtonId();
                    double taxPercent;
                    if (id == R.id.radioGroupButton0)
                    {
                        taxPercent = 0.15;
                    }
                    else if (id == R.id.radioGroupButton1)
                    {
                        taxPercent = 0.18;
                    }
                    else if (id == R.id.radioGroupButton2)
                    {
                        taxPercent = 0.20;
                    }
                    else //User didn't check anything, assume 0 percent tax
                    {
                        taxPercent = 0.0;
                    }

                    //Setup Strings to be put on screen
                    String taxString = "Tax Amount: $" + String.format("%.2f", (taxPercent * floatingMealPrice));
                    String finalBillString = "Full Price: $" + String.format("%.2f", (floatingMealPrice + (taxPercent * floatingMealPrice)));

                    //Push Strings created to user screen (activity_main.xml)
                    finalAmount.setText(finalBillString);
                    taxAmount.setText(taxString);
                }
                catch (Exception e) {
                    finalAmount.setText("Please Enter a valid bill total");
                    taxAmount.setText(" ");
                }
            }
        });
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