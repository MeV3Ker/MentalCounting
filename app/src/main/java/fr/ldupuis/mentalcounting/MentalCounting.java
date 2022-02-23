package fr.ldupuis.mentalcounting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MentalCounting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_counting);

        //init button
        Button mainMenuButton = findViewById(R.id.main_menu_button);

        //init button listener
        mainMenuButton.setOnClickListener(view -> openMainMenu());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        int id = item.getItemId();

        if (id == R.id.menuBar_score) {
            Intent intent = new Intent(this, Score.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.score_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void openMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void Submit() {
        //submit button
        Button submitButton = findViewById(R.id.submit_button);

        //in.correct tags
        TextView correct_D = findViewById(R.id.display_correct_answer);
        TextView incorrect_D = findViewById(R.id.display_incorrect_answer);

        //operation generator
        

        //user input
        EditText input = findViewById(R.id.submit_Operation_answer);
        String answer = input.getText().toString();

        //init button listener
        submitButton.setOnClickListener(view -> {
            if (answer == operation.result)
                incorrect_D.setVisibility(TextView.VISIBLE);
            else
                correct_D.setVisibility(TextView.VISIBLE);
        });
    }
}