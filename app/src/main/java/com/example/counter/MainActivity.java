package com.example.counter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    public static final String EXTRA_MESSAGE = "com.example.counter.EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setViewText() {
        String s = String.valueOf(counter);
        TextView textView = findViewById(R.id.counter_value);
        textView.setText(String.valueOf(counter));
    }

    public void increment(View view) {
        counter++;
        setViewText();
    }

    public void decrement(View view) {
        counter--;
        setViewText();
    }

    public void reset(View view) {
        counter = 0;
        setViewText();
    }

    public void setCounter(View view){
        Intent intent = new Intent(this, DisplayCounter.class);
        EditText editCounter = findViewById(R.id.counter_value);
        String counter = editCounter.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, counter);
        startActivity(intent);
    }
}