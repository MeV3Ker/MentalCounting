package fr.ldupuis.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.play_button);
        Button scoreButton = findViewById(R.id.score_button);
        
        playButton.setOnClickListener(view -> openMentalCounting());
        scoreButton.setOnClickListener(view-> openScore());
    }


    private void openScore() {
    }

    private void openMentalCounting() {
    }
}