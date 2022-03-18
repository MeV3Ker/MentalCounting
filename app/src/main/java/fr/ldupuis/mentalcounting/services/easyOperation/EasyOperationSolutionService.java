package fr.ldupuis.mentalcounting.services.easyOperation;

import androidx.annotation.NonNull;

import fr.ldupuis.mentalcounting.models.EasyOperationModel;
import fr.ldupuis.mentalcounting.models.exceptions.EmptyOperatorException;
import fr.ldupuis.mentalcounting.models.exceptions.EmptyResultException;

/**
 * Class de résolution d'opération facile. Permet de calculer le résultat d'une opération générée aléatoirement ou de comparer une opération à un résultat donné
 */
public class EasyOperationSolutionService {

    /**
     * Vérifie si une opération passée en paramètre est égal au résultat passé en paramètre
     * @param easyModel Opération facile passée en paramètre
     * @param submittedStringResult Résultat saisi par l'utilisateur qui doit être vérifié
     * @return Valeur de vérité de l'égalité entre l'opération et le résultat saisi
     * @throws ArithmeticException Erreur de division par 0, impossible sauf si modification du numberGenerator dans EasyOperationGenerationService
     * @throws EmptyResultException Erreur de résultat NULL, l'utilisateur n'a rien rentré dans la zone de texte.
     * @throws EmptyOperatorException Erreur d'opérateur NULL, impossible sauf modification de operatorGenerator dans EasyOperationGenerationService
     */
    public static boolean isEqual(@NonNull EasyOperationModel easyModel, String submittedStringResult) throws ArithmeticException, EmptyResultException, EmptyOperatorException {

        int first = easyModel.getFirstOperationMember();
        int second = easyModel.getSecondOperationMember();
        String operator = easyModel.getOperator();
        int operationResult;

        if(submittedStringResult.isEmpty()){
            throw new EmptyResultException("Answer cannot be null");
        }
        int submittedIntResult = Integer.parseInt(submittedStringResult);


        switch (operator) {
            case "+":
                operationResult = first + second;
                break;
            case "-":
                operationResult = first - second;
                break;
            case "*":
                operationResult = first * second;
                break;
            case "/":

                operationResult = first / second;
                break;
            default:
                //Techniquement impossible, operatorGenerator possède un default qui empêche ce bug
                throw new EmptyOperatorException("Error, operatorGenerator in EasyOperationGenrationService was modified");
        }

        return operationResult == submittedIntResult;
    }

    /**
     * Calcul le résultat d'une opération passé en paramètre via un modèle
     * @param easyModel Opération facile passée en paramètre
     * @return Valeur entière du résultat de l'opération
     * @throws ArithmeticException Erreur de division par 0, impossible sauf si modification du numberGenerator dans EasyOperationGenerationService
     * @throws EmptyOperatorException Erreur d'opérateur NULL, impossible sauf modification de operatorGenerator dans EasyOperationGenerationService
     */
    public static int compute(EasyOperationModel easyModel) throws ArithmeticException, EmptyOperatorException{

        int first = easyModel.getFirstOperationMember();
        int second = easyModel.getSecondOperationMember();
        String operator = easyModel.getOperator();
        int operationResult;

        switch (operator) {
            case "+":
                operationResult = first + second;
                break;
            case "-":
                operationResult = first - second;
                break;
            case "*":
                operationResult = first * second;
                break;
            case "/":
                try {
                    operationResult = first / second;
                }catch (ArithmeticException e){//Théoriquement impossible
                    e = new ArithmeticException("Cannot divide by 0");
                    throw e;
                }

                break;
            default:
                //Techniquement impossible, operatorGenerator possède un default qui empêche ce bug
                throw new EmptyOperatorException("Error, operatorGenerator in EasyOperationGenrationService was modified");
        }


        return operationResult;
    }

    /**
     * Calcul le résultat d'une opération via les données passées individuellement en paramètre
     * @param first Valeur du premier terme de l'opération
     * @param operator Type de l'opération
     * @param second Valeur du second terme de l'opération
     * @return Résultat entier de l'opération
     * @throws ArithmeticException Erreur de division par 0, impossible sauf si modification du numberGenerator dans EasyOperationGenerationService
     * @throws EmptyOperatorException Erreur d'opérateur NULL, impossible sauf modification de operatorGenerator dans EasyOperationGenerationService
     */
    public static int compute(int first, String operator, int second) throws ArithmeticException, EmptyOperatorException{

        int operationResult;

        switch (operator) {
            case "+":
                operationResult = first + second;
                break;
            case "-":
                operationResult = first - second;
                break;
            case "*":
                operationResult = first * second;
                break;
            case "/":

                try {
                    operationResult = first / second;
                }catch (ArithmeticException e){//Théoriquement impossible
                    e = new ArithmeticException("Cannot divide by 0");
                    throw e;
                }

                break;
            default:
                //Techniquement impossible, operatorGenerator possède un default qui empêche ce bug
                throw new EmptyOperatorException("Error, operatorGenerator in EasyOperationGenrationService was modified");
        }


        return operationResult;
    }
}
