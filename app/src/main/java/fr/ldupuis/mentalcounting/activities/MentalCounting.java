package fr.ldupuis.mentalcounting.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import fr.ldupuis.mentalcounting.R;
import fr.ldupuis.mentalcounting.models.EasyOperationModel;
import fr.ldupuis.mentalcounting.models.HardOperationModel;
import fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationGenerationService;
import fr.ldupuis.mentalcounting.services.hardOperation.HardOperationGenerationService;

public class MentalCounting extends AppCompatActivity {
    private TextView displayOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_counting);


        //Recuperation Extra
        Intent intent = getIntent();
        boolean isHard = intent.getBooleanExtra("IS_HARD", false);

        //Recuperation zone de texte
        displayOperation = findViewById(R.id.display_Operation);

        //init button
        Button mainMenuButton = findViewById(R.id.main_menu_button);

        //init button listener
        mainMenuButton.setOnClickListener(view -> openMainMenu());

        //Operation et model
        if(isHard){
            HardOperationGenerationService generatedHardOperation = new HardOperationGenerationService();
            HardOperationModel generatedOperationModel = new HardOperationModel(generatedHardOperation);
            writeHardOperationText(generatedOperationModel);
        }
        else{
            EasyOperationGenerationService generatedEasyOperation = new EasyOperationGenerationService();
            EasyOperationModel generatedOperationModel = new EasyOperationModel(generatedEasyOperation);
            writeEasyOperationText(generatedOperationModel);
        }

    }
    private void openMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void writeEasyOperationText(EasyOperationModel easyModel){
        String operationText;
        operationText = this.displayOperation.getText() + easyModel.toString();

        this.displayOperation.setText(operationText);
    }

    private void writeHardOperationText(HardOperationModel hardModel){
        String operationText;
        operationText = this.displayOperation.getText() + hardModel.toString();

        this.displayOperation.setText(operationText);

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



}