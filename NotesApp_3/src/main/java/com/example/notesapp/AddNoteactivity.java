package com.example.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText contentEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        titleEditText = findViewById(R.id.titleEditText);
        contentEditText = findViewById(R.id.contentEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(view -> {
            String title = titleEditText.getText().toString();
            String content = contentEditText.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("title", title);
            intent.putExtra("content", content);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}