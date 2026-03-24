package ru.mirea.aleksandrovma.toastapp;

import android.os.Bundle;import android.view.View;import android.widget.EditText;import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextText = findViewById(R.id.editTextText);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickCountChars(View view) {
        String text = editTextText.getText().toString();  // используем уже найденное поле
        int count = text.length();

        Toast toast = Toast.makeText(getApplicationContext(),
                "Студент № 2 БСБО-50-24 Количество символов - " + count,
                Toast.LENGTH_SHORT);
        toast.show();
    }
}