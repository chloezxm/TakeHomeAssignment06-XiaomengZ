package com.android.takehomeassignment06_xiaomengz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    EditText tax;
    EditText tip;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Tip Calculator");

        amount = findViewById(R.id.amount);
        tax = findViewById(R.id.tax);
        tip = findViewById(R.id.tip);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountString = amount.getText().toString();
                String taxString = tax.getText().toString();
                String tipString = tip.getText().toString();

                if (isNotEmpty(amountString) && isNotEmpty(taxString) && isNotEmpty(tipString)) {
                    Intent intent = new Intent(MainActivity.this, ReceiptActivity.class);
                    intent.putExtra("amount", Double.parseDouble(amountString));
                    intent.putExtra("tax", Double.parseDouble(taxString));
                    intent.putExtra("tip", Double.parseDouble(tipString));
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isNotEmpty(String s) {
        return (s != null && s.length() > 0);
    }
}
