package fr.ldupuis.mentalcounting.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import fr.ldupuis.mentalcounting.R;

/**
 * Class permettant à l'utilisateur de choisir sa difficulté. Cette dernière est passée en Extra.
 */
public class DifficultyActivity extends AppCompatActivity {

    /**
     * Initialisation de la page de choix des difficultés, des boutons et des listeners
     * @param savedInstanceState
     */
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

    /**
     * Ouvre l'activité de jeu en mode difficile
     */
    private void openMentalCountingHard(){
        Intent open_MentalCounting = new Intent(this, MentalCounting.class);
        open_MentalCounting.putExtra("IS_HARD", true);
        startActivity(open_MentalCounting);
    }

    /**
     * Ouvre l'activité de jeu en mode facile
     */
    private void openMentalCountingEasy(){
        Intent open_MentalCounting = new Intent(this, MentalCounting.class);
        open_MentalCounting.putExtra("IS_HARD", false);
        startActivity(open_MentalCounting);
    }

    /**
     * Retourne au menu principal
     */
    private void previousPage(){
        finish();
    }
}