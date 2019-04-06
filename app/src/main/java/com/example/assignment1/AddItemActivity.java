package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {
    Button addItem;
    TextView name, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        addItem = findViewById(R.id.BaddToList);
        name = findViewById(R.id.etName);
        desc = findViewById(R.id.etDesc);
        addItem.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(AddItemActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", name.getText().toString());
        bundle.putString("desc", desc.getText().toString());
        i.putExtras(bundle);
        setResult(RESULT_OK, i);
        finish();

    }
}
