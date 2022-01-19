package com.dynamiclayoutdirecttypingandshowtextdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layoutList;
    Button buttonAdd;
    EditText inputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutList = findViewById(R.id.layout_list);
        buttonAdd = findViewById(R.id.button_add);
        inputEditText = findViewById(R.id.inputEditText);

        buttonAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        addView();
    }



    private void addView() {


        final View cricketerView = getLayoutInflater().inflate(R.layout.row_add_cricketer, null, false);
        TextView textView = cricketerView.findViewById(R.id.edit_cricketer_name);
        Toast.makeText(this, "Please write something "+ textView.getText().toString().trim(), Toast.LENGTH_SHORT).show();
        if (!TextUtils.isEmpty(textView.getText().toString().trim())){
            textView.setText(inputEditText.getText());
            layoutList.addView(cricketerView);
        }else {
            Toast.makeText(this, "Please write something ", Toast.LENGTH_SHORT).show();
        }
        ImageView imageClose = cricketerView.findViewById(R.id.image_remove);
        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeView(cricketerView);
            }
        });
    }

    private void removeView(View view) {
        layoutList.removeView(view);
    }
}