package fr.ldupuis.mentalcounting.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import fr.ldupuis.mentalcounting.R;

public class DifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        //Initialisation Boutons
        Button hardButton = findViewById(R.id.hard_button);
        Button easyButton = findViewById(R.id.easy_button);
        Button menuButton = findViewById(R.id.main_menu);

        //Initialisation Listener Boutons
        hardButton.setOnClickListener(view -> openMentalCountingHard());
        easyButton.setOnClickListener(view -> openMentalCountingEasy());
        menuButton.setOnClickListener(view -> previousPage());

    }

    private void openMentalCountingHard(){
        Intent open_MentalCounting = new Intent(this, MentalCounting.class);
        open_MentalCounting.putExtra("IS_HARD", true);
        startActivity(open_MentalCounting);
    }

    private void openMentalCountingEasy(){
        Intent open_MentalCounting = new Intent(this, MentalCounting.class);
        open_MentalCounting.putExtra("IS_HARD", false);
        startActivity(open_MentalCounting);
    }

    private void previousPage(){
        finish();
    }
}