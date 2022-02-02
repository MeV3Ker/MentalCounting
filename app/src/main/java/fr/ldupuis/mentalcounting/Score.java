package fr.ldupuis.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

public class Score extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button previousButton = findViewById(R.id.previous_button);
        previousButton.setOnClickListener(view -> previousPage());
    }

    private void previousPage(){finish();}
}
