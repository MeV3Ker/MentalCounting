package fr.ldupuis.mentalcounting.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

import fr.ldupuis.mentalcounting.R;

/**
 * Class de score, permet à l'utilisateur de consulter ses scores.
 * Actuellement un placeholder, base de données non mise en place
 * Ne fonctionne pas
 */
public class ScoreActivity extends AppCompatActivity {

    /**
     * Initialisation de la page des scores, du bouton et du listener
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button previousButton = findViewById(R.id.previous_button);
        previousButton.setOnClickListener(view -> previousPage());
    }

    private void previousPage(){finish();}
}
