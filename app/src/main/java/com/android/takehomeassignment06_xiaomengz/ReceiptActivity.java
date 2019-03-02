package com.android.takehomeassignment06_xiaomengz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiptActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        setTitle("Your Receipt");

        Intent intent = getIntent();
        double amount = intent.getDoubleExtra("amount", 0);
        double tax = intent.getDoubleExtra("tax", 0);
        double tip = intent.getDoubleExtra("tip", 0);

        textView = findViewById(R.id.receipt);
        textView.setText("Total: " + amount + "\n" +
                "Sales Tax: " + tax * amount + "\n" +
                "Tip: " + tip * amount + "\n" +
                "Grand Total: " + amount * (1 + tax + tip));
    }
}
