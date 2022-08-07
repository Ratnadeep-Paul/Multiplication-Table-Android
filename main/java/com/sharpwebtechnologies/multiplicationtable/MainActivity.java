package com.sharpwebtechnologies.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableShow(1);

        SeekBar numberSeek = findViewById(R.id.numberSeek);
        numberSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress<20){
                    progress++;
                    tableShow(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }


    void tableShow(int number){
        ArrayList<String> tableArr = new ArrayList<>();
        ListView tableView = findViewById(R.id.table);

        EditText numberPic = findViewById(R.id.numberInput);
        TextView tableNumber = findViewById(R.id.tableNumber);
        for (int i = 1; i<11; i++){
            if (number==0){
                String tableLine = 1 + " X " + i + " = " + (1*i);
                tableArr.add(tableLine);
                tableNumber.setText("Table Of 1");
                numberPic.setText("1");
            } else {
                String tableLine = number + " X " + i + " = " + (number*i);
                tableArr.add(tableLine);
                tableNumber.setText("Table Of " + Integer.toString(number));
            }

            String numberString = Integer.toString(number);
            numberPic.setText(numberString);

        }

        ArrayAdapter<String> arrAdapter = new ArrayAdapter<>(this, R.layout.list_view_text, tableArr);
        tableView.setAdapter(arrAdapter);
    }

    public void searchTable(View view){
        EditText numberPic = findViewById(R.id.numberInput);
        String numberString = numberPic.getText().toString();
        int finalNumber = Integer.parseInt(numberString);

        tableShow(finalNumber);

        if (finalNumber<20){
            SeekBar numberSeek = findViewById(R.id.numberSeek);
            numberSeek.setProgress(finalNumber);
        } else {
            SeekBar numberSeek = findViewById(R.id.numberSeek);
            numberSeek.setProgress(20);
        }
    }
}