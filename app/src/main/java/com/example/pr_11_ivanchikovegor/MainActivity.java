package com.example.pr_11_ivanchikovegor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public boolean Started = false;
    public boolean Finished = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
    }
    public void Start (View view) {
        Button button = (Button)findViewById(R.id.start);
        if (!Finished) {
            if (!Started) {
                button.setBackgroundColor(Color.RED);
                button.setText("Pause");
                Started = true;
            } else if (Started) {
                button.setBackgroundColor(Color.GREEN);
                button.setText("Start");
                Started = false;
            }
            View Car = (View)findViewById(R.id.car2);
            TextView result = (TextView)findViewById(R.id.Result);
            if (!Finished) {
                ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) Car.getLayoutParams();
                margin.leftMargin += 20;
                Car.requestLayout();
                if (margin.rightMargin <= -1150) {
                    result.setText("Victory of the second plaer");
                    result.setTextColor(0xffe21E63);
                }
            }


                }
            else {
                Intent intent =new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }

        public void Drive1 (View view){
        Button Button = (Button)findViewById(R.id.start);
        View Car = (View)findViewById(R.id.car1);
        TextView result = (TextView)findViewById(R.id.Result);
        if (Started && !Finished) {
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin+=40;
            Car.requestLayout();
            if(margin.rightMargin <=-1150){
                result.setText("Victory of the first plaer");
                Button.setText("Again");
                result.setTextColor(0xffe91E63);
                Finished = true;
                Started = false;
            }
        }
    }
//    public void Drive2 (View view){
//        Button Button = (Button)findViewById(R.id.start);
//        View Car = (View)findViewById(R.id.car2);
//        TextView result = (TextView)findViewById(R.id.Result);
//        if (Started && !Finished) {
//            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) Car.getLayoutParams();
//            margin.leftMargin += 40;
//            margin.rightMargin -= 40;
//            Car.requestLayout();
//            if (margin.rightMargin <= -1150) {
//                result.setText("Victory of the second plaer");
//                Button.setText("Again");
//                result.setTextColor(0xffe21E63);
//                Finished = true;
//                Started = false;
//            }
//        }
//    }
}




