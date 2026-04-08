package ru.mirea.aleksandrovma.favoritebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_share);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView textViewBook = findViewById(R.id.textViewBookDeveloper);
            String book_name = extras.getString(MainActivity.BOOK_NAME_KEY);
            String quotes_name = extras.getString(MainActivity.QUOTES_KEY);
            textViewBook.setText(String.format("Моя любимая книга: %s и цитата %s", book_name, quotes_name));
        }

        EditText editTextBook = findViewById(R.id.editTextBook);
        EditText editTextQuote = findViewById(R.id.editTextQuote);

        findViewById(R.id.buttonSend).setOnClickListener(v -> {
            String userBook = editTextBook.getText().toString();
            String userQuote = editTextQuote.getText().toString();
            Intent data = new Intent();
            data.putExtra(MainActivity.USER_MESSAGE, "Книга: " + userBook + ". Цитата: " + userQuote);
            setResult(RESULT_OK, data);
            finish();
        });
    }
}