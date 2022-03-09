package fr.ldupuis.mentalcounting.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import fr.ldupuis.mentalcounting.R;

public class MentalCounting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_counting);

        //Recuperation Extra
        Intent intent = getIntent();
        boolean is_hard = intent.getBooleanExtra("IS_HARD", false);

        //init button
        Button mainMenuButton = findViewById(R.id.main_menu_button);

        //init button listener
        mainMenuButton.setOnClickListener(view -> openMainMenu());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        int id = item.getItemId();

        if (id == R.id.menuBar_score) {
            Intent intent = new Intent(this, ScoreActivity.class);
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

}