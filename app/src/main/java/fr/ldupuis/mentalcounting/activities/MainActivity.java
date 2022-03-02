package fr.ldupuis.mentalcounting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.ldupuis.mentalcounting.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init button
        Button playButton = findViewById(R.id.play_button);
        Button scoreButton = findViewById(R.id.score_button);

        //Init button listener
        playButton.setOnClickListener(view -> openMentalCounting());
        scoreButton.setOnClickListener(view-> openScore());
    }


    private void openScore() {
        Intent openScore = new Intent(this, ScoreActivity.class);
        startActivity(openScore);
    }


    private void openMentalCounting() {

        Intent open_MentalCounting = new Intent(this, MentalCounting.class);
        startActivity(open_MentalCounting);
    }
}