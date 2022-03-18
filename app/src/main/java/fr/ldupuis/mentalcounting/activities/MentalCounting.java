package fr.ldupuis.mentalcounting.activities;

import static fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationSolutionService.compute;
import static fr.ldupuis.mentalcounting.services.hardOperation.HardOperationSolutionService.computeHard;
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
import fr.ldupuis.mentalcounting.models.exceptions.EmptyOperatorException;
import fr.ldupuis.mentalcounting.models.exceptions.EmptyResultException;
import fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationGenerationService;
import fr.ldupuis.mentalcounting.services.hardOperation.HardOperationGenerationService;

/**
 * Class de jeu, permet à l'utilisateur de jouer au jeu mental counting
 */
public class MentalCounting extends AppCompatActivity {
    private TextView displayOperation;
    private final static int EASY_UPPERBOUND = 12; //Valeur MAX des opération facile

    /**
     * Initialisation des boutons et des listener.
     * Fait appel, en fonction de la difficulté passée en extra, aux services de génération et de solutions. Gère l'affichage des messages.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_counting);


        //Recuperation Extra
        Intent intent = getIntent();
        boolean isHard = intent.getBooleanExtra("IS_HARD", false);

        //Recuperation zone de texte
        displayOperation = findViewById(R.id.display_Operation);

        //Effacer les textes, messages et boutons
        Button nextOperation = findViewById(R.id.next_button);// Nécessaire ici car il doit être effacé
        nextOperation.setVisibility(View.GONE);

        TextView correctMessage = findViewById(R.id.display_correct_answer);
        correctMessage.setVisibility(View.GONE);

        TextView incorrectMessage = findViewById(R.id.display_incorrect_answer);
        incorrectMessage.setVisibility(View.GONE);
        TextView errorMessage = findViewById(R.id.error_message);
        errorMessage.setVisibility(View.GONE);

        //Initialisation des boutons
        Button mainMenuButton = findViewById(R.id.main_menu_button);
        Button submitAnswerButton = findViewById(R.id.submit_button);


        //Initialisation des listener
        mainMenuButton.setOnClickListener(view -> openMainMenu());
        nextOperation.setOnClickListener(view -> nextOperation(isHard));

        TextView submittedResult = findViewById(R.id.submit_Operation_answer);

        //Operation et model
        //Gestion des difficultés
        if(isHard){
            HardOperationGenerationService generatedHardOperation = new HardOperationGenerationService();
            HardOperationModel generatedHardOperationModel = new HardOperationModel(generatedHardOperation);
            writeHardOperationText(generatedHardOperationModel);

            submitAnswerButton.setOnClickListener(view -> hardResultControl(generatedHardOperationModel, getStringResult(submittedResult) ));
        }
        else{
            EasyOperationGenerationService generatedEasyOperation = new EasyOperationGenerationService(12);
            EasyOperationModel generatedEasyOperationModel = new EasyOperationModel(generatedEasyOperation);
            writeEasyOperationText(generatedEasyOperationModel);

            submitAnswerButton.setOnClickListener(view -> easyResultControl(generatedEasyOperationModel, getStringResult(submittedResult)));
        }


    }

    /**
     * Récupère le résultat saisi par l'utilisateur et le converti en String
     * @param submittedResult Résultat saisi par l'utilisateur de type CharSequence
     * @return Résultat saisi par l'utilisateur de type String
     */
    private String getStringResult(TextView submittedResult) {
        String resultToString;

        resultToString = String.valueOf(submittedResult.getText());;

        return resultToString;
    }

    /**
     * Vérifie si le résultat saisi par l'utilisateur est bon pour une opération difficile.
     * Affiche un message d'erreur si l'utilisateur ne tape rien et rentre la réponse.
     * @param hardModel Données de l'opération générée
     * @param resultString Résultat saisi par l'utilisateur en String
     */
    private void hardResultControl(HardOperationModel hardModel, String resultString) {
        int correctAnswer;
        try {
            correctAnswer = computeHard(hardModel);
        }catch (EmptyOperatorException e){
            Button submit = findViewById(R.id.submit_button);
            Button nextButton = findViewById(R.id.next_button);

            TextView errorMessage = findViewById(R.id.error_message);
            errorMessage.setText(e.getMessage());
            errorMessage.setVisibility(View.VISIBLE);

            submit.setVisibility(View.GONE);
            nextButton.setVisibility(View.VISIBLE);
            return;
        }


        try {
            affichageMessage(isEqual(hardModel, resultString), correctAnswer);
        }catch (EmptyResultException e) {
            Button submit = findViewById(R.id.submit_button);
            Button nextButton = findViewById(R.id.next_button);

            TextView errorMessage = findViewById(R.id.error_message);
            errorMessage.setText(e.getMessage());
            errorMessage.setVisibility(View.VISIBLE);

            submit.setVisibility(View.GONE);
            nextButton.setVisibility(View.VISIBLE);
        }catch (EmptyOperatorException e){

            Button submit = findViewById(R.id.submit_button);
            Button nextButton = findViewById(R.id.next_button);

            TextView errorMessage = findViewById(R.id.error_message);
            errorMessage.setText(e.getMessage());
            errorMessage.setVisibility(View.VISIBLE);

            submit.setVisibility(View.GONE);
            nextButton.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Vérifie si le résultat saisi par l'utilisateur est bon pour une opération facile.
     * Affiche un message d'erreur si l'utilisateur ne tape rien et rentre la réponse.
     * Affixhe les messages d'erreurs programme
     * @param easyModel Données de l'opération générée
     * @param resultString Résultat saisi par l'utilisateur en String
     */
    private void easyResultControl(EasyOperationModel easyModel, String resultString){
        int correctAnswer;

        try {
            correctAnswer = compute(easyModel);
        }catch (EmptyOperatorException e){

            Button submit = findViewById(R.id.submit_button);
            Button nextButton = findViewById(R.id.next_button);

            TextView errorMessage = findViewById(R.id.error_message);
            errorMessage.setText(e.getMessage());
            errorMessage.setVisibility(View.VISIBLE);

            submit.setVisibility(View.GONE);
            nextButton.setVisibility(View.VISIBLE);

            return;
        }

        try {
            affichageMessage(isEqual(easyModel, resultString), correctAnswer);
        }catch (EmptyResultException e) {
            Button submit = findViewById(R.id.submit_button);
            Button nextButton = findViewById(R.id.next_button);

            TextView errorMessage = findViewById(R.id.error_message);
            errorMessage.setText(e.getMessage());
            errorMessage.setVisibility(View.VISIBLE);

            submit.setVisibility(View.GONE);
            nextButton.setVisibility(View.VISIBLE);

        }catch (EmptyOperatorException e){
            Button submit = findViewById(R.id.submit_button);
            Button nextButton = findViewById(R.id.next_button);

            TextView errorMessage = findViewById(R.id.error_message);
            errorMessage.setText(e.getMessage());
            errorMessage.setVisibility(View.VISIBLE);

            submit.setVisibility(View.GONE);
            nextButton.setVisibility(View.VISIBLE);
        }

    }

    /**
     * Affiche un message en fonction de la réponse de l'utilisateur.
     * Si la réponse est fausse, affiche la bonne réponse.
     * @param answerCorrect Valeur de vérité de la réponse de l'utilisateur (La réponse est bonne ?)
     * @param correctResult Résultat réel du calcul généré
     */
    private void affichageMessage(boolean answerCorrect, int correctResult){

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
            String text = getString(R.string.incorrect_answer, correctResult);
            incorrectMessage.setText(text);
            incorrectMessage.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Renvoi vers cette activité pour générer un nouveau calcul, garde en mémoire la difficulté.
     * @param difficulty Valeur de difficulté choisi par l'utilisateur, sert de mémoire pour la prochaine opération.
     */
    private void nextOperation(boolean difficulty) {
        Intent nextOperation = new Intent(this, MentalCounting.class);
        nextOperation.putExtra("IS_HARD", difficulty);
        startActivity(nextOperation);

        finish();
    }


    /**
     * Redirige vers le menu principal
     */
    private void openMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    /**
     * Ecrit dans la zone "Operation" le calcul facile généré aléatoirement
     * @param easyModel Contient les données de l'opération générée
     */
    private void writeEasyOperationText(EasyOperationModel easyModel){
        String operationText;
        operationText = getString(
                R.string.easy_operationTemplate,
                easyModel.getFirstOperationMember(),
                easyModel.getOperator(),
                easyModel.getSecondOperationMember());

        this.displayOperation.setText(operationText);
    }

    /**
     * Ecrit dans la zone "Operation" le calcul difficile généré aléatoirement
     * @param hardModel Contient les données de l'opération générée
     */
    private void writeHardOperationText(HardOperationModel hardModel){
        String operationText;
        operationText = getString(
                R.string.hard_operationTemplate,
                hardModel.getFirstOperationMember(),
                hardModel.getOperator(),
                hardModel.getSecondOperationMember(),
                hardModel.getSecondOperator(),
                hardModel.getThirdOperationMember()
                );

        this.displayOperation.setText(operationText);

    }

    /**
     * Gère les boutons dans le menu, renvoi à la page des score
     * @param item bouton sur lequel on a appuyé (bouton "scores")
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        int id = item.getItemId();

        if (id == R.id.menuBar_score) {
            Intent intent = new Intent(this, ScoreActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Gère le menu dans ka barre de tâches, affiche le menu une fois cliqué sur l'icône
     * @param menu bouton sur lequel on a appuyé (bouton "menu")
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.score_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }



}