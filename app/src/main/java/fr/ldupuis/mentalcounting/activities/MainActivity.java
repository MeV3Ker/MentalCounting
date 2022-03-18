package fr.ldupuis.mentalcounting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.ldupuis.mentalcounting.R;

/**
 * Class générant le menu principal, permet à l'utilisateur de choisir la difficulté du jeu, ou de voir ses scores
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Initialisation du menu principal, des boutons et des listeners
     * @param savedInstanceState
     */
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

    /**
     * Ouvre l'activité des scores
     */
    private void openScore() {
        Intent openScore = new Intent(this, ScoreActivity.class);
        startActivity(openScore);
    }

    /**
     * Ouvre l'activité du choix de difficulté
     */
    private void openDifficulty() {
        Intent open_Difficulty = new Intent(this, DifficultyActivity.class);
        startActivity(open_Difficulty);

    }
}