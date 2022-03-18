package fr.ldupuis.mentalcounting.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import fr.ldupuis.mentalcounting.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialisation Boutons
        Button playButton = findViewById(R.id.play_button);
        Button scoreButton = findViewById(R.id.score_button);

        //Initialisation Listener boutons
        playButton.setOnClickListener(view -> openDifficulty());
        scoreButton.setOnClickListener(view -> openScore());
    }


    private void openScore() {
        Intent openScore = new Intent(this, ScoreActivity.class);
        startActivity(openScore);
    }

    private void openDifficulty() {
        Intent open_Difficulty = new Intent(this, DifficultyActivity.class);
        startActivity(open_Difficulty);

    }
}