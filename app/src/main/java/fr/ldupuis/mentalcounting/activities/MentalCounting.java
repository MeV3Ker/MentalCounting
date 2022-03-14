package fr.ldupuis.mentalcounting.activities;

import static fr.ldupuis.mentalcounting.services.hardOperation.HardOperationSolutionService.isEqual;
import static fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationSolutionService.isEqual;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.ldupuis.mentalcounting.R;
import fr.ldupuis.mentalcounting.models.EasyOperationModel;
import fr.ldupuis.mentalcounting.models.HardOperationModel;
import fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationGenerationService;
import fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationSolutionService;
import fr.ldupuis.mentalcounting.services.hardOperation.HardOperationGenerationService;
import fr.ldupuis.mentalcounting.services.hardOperation.HardOperationSolutionService;

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

        //Effacer les textes/message
        Button nextOperation = findViewById(R.id.next_button);
        nextOperation.setVisibility(View.GONE);

        TextView correctMessage = findViewById(R.id.display_correct_answer);
        correctMessage.setVisibility(View.GONE);

        TextView incorrectMessage = findViewById(R.id.display_incorrect_answer);
        incorrectMessage.setVisibility(View.GONE);

        //init button
        Button mainMenuButton = findViewById(R.id.main_menu_button);
        Button submitAnswerButton = findViewById(R.id.submit_button);
        Button nextOperationButton = findViewById(R.id.next_button);

        //init button listener
        mainMenuButton.setOnClickListener(view -> openMainMenu());
        nextOperation.setOnClickListener(view -> nextOperation(isHard));

        TextView submittedResult = findViewById(R.id.submit_Operation_answer);

        //Operation et model
        //Gestion des difficultés
        if(isHard){
            HardOperationGenerationService generatedHardOperation = new HardOperationGenerationService();
            HardOperationModel generatedHardOperationModel = new HardOperationModel(generatedHardOperation);
            writeHardOperationText(generatedHardOperationModel);

            submitAnswerButton.setOnClickListener(view -> hardResultControl(generatedHardOperationModel, getResult(submittedResult) ));
        }
        else{
            EasyOperationGenerationService generatedEasyOperation = new EasyOperationGenerationService();
            EasyOperationModel generatedEasyOperationModel = new EasyOperationModel(generatedEasyOperation);
            writeEasyOperationText(generatedEasyOperationModel);

            submitAnswerButton.setOnClickListener(view -> easyResultControl(generatedEasyOperationModel, getResult(submittedResult)));
        }


    }


    //Récupère le résultat saisi par l'utilisateur et le converti en entier
    private int getResult(TextView submittedResult) {
        int resultValue;
        String resultToString;

        resultToString = String.valueOf(submittedResult.getText());
        resultValue = Integer.parseInt(resultToString);

        return resultValue;
    }

    //Vérifie si le résultat est bon
    private void hardResultControl(HardOperationModel hardModel, int result) {
       affichageMessage(isEqual(hardModel, result));
    }

    //Vérifie si le résultat est bon
    private void easyResultControl(EasyOperationModel easyModel, int result){
        affichageMessage(isEqual(easyModel, result));

    }

    //Affiche les messages d'erreur/reussite et les boutons pour passer au calcul suivant
    private void affichageMessage(boolean answerCorrect){

        Button submit = findViewById(R.id.submit_button);
        Button nextButton = findViewById(R.id.next_button);
        TextView correctMessage = findViewById(R.id.display_correct_answer);
        TextView incorrectMessage = findViewById(R.id.display_incorrect_answer);

        submit.setVisibility(View.GONE);
        nextButton.setVisibility(View.VISIBLE);

        if(answerCorrect){
            correctMessage.setVisibility(View.VISIBLE);
        }
        else{
            incorrectMessage.setVisibility(View.VISIBLE);
        }

    }

    //Passe au calcul suivant
    private void nextOperation(boolean difficulty) {
        Intent nextOperation = new Intent(this, MentalCounting.class);
        nextOperation.putExtra("IS_HARD", difficulty);
        startActivity(nextOperation);
    }


    // Redirige vers le menu principal
    private void openMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Ecrit une opération à 2 membres
    private void writeEasyOperationText(EasyOperationModel easyModel){
        String operationText;
        operationText = getString(
                R.string.easy_operationTemplate,
                easyModel.getFirstOperationMember(),
                easyModel.getOperator(),
                easyModel.getSecondOperationMember());

        this.displayOperation.setText(operationText);
    }

    //Ecrit une opération à 3 membres
    private void writeHardOperationText(HardOperationModel hardModel){
        String operationText;
        operationText = getString(
                R.string.hard_operationTemplate,
                hardModel.getFirstOperationMember(),
                hardModel.getFirstOperator(),
                hardModel.getSecondOperationMember(),
                hardModel.getSecondOperator(),
                hardModel.getThirdOperationMember()
                );

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