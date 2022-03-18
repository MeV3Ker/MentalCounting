package fr.ldupuis.mentalcounting.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import fr.ldupuis.mentalcounting.R;

public class ScoreActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button previousButton = findViewById(R.id.previous_button);
        previousButton.setOnClickListener(view -> previousPage());
    }

    private void previousPage(){finish();}
}
