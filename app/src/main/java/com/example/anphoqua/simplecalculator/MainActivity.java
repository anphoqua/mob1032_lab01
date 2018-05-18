package com.example.anphoqua.simplecalculator;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_length, edt_width;
    Button btn_solve;
    TextView textView_primeter, textView_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_length = findViewById(R.id.edt_lengthNumber);
        edt_width = findViewById(R.id.edt_widthNumber);
        btn_solve = findViewById(R.id.btn_solve);
        textView_primeter = findViewById(R.id.textview_primeter);
        textView_area = findViewById(R.id.textview_area);

        btn_solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
                int a = Integer.parseInt(edt_length.getText().toString().trim());
                int b = Integer.parseInt(edt_width.getText().toString().trim());
                textView_primeter.setText(String.valueOf(rectanglePerimeter(a,b)));
                textView_area.setText(String.valueOf(rectangleArea(a,b)));
            }
        });
    }

    public int rectanglePerimeter(int length, int width){
        return ((length + width)*2);
    }

    public int rectangleArea(int length, int width){
        return (length*width);
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
