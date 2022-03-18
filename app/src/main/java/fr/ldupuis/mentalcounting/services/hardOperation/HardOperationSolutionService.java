package fr.ldupuis.mentalcounting.services.hardOperation;


import androidx.annotation.NonNull;

import fr.ldupuis.mentalcounting.models.HardOperationModel;
import fr.ldupuis.mentalcounting.models.exceptions.EmptyOperatorException;
import fr.ldupuis.mentalcounting.models.exceptions.EmptyResultException;
import fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationSolutionService;

/**
 * Class de résolution d'opération difficile. Permet de calculer une opération à trois termes en prenant en compte les priorités d'opération.
 * Permet également de comparer une opération à un résultat donné
 */
public class HardOperationSolutionService extends EasyOperationSolutionService {

    /**
     * Permet de vérifier si un résultat donné est égal à une opération
     * @param hardModel Modèle contenant les données de l'opération
     * @param submittedStringResult Résultat saisi par l'utilisateur
     * @return Valeur de vérité de l'égalité entre l'opération et le résultat saisi
     * @throws EmptyResultException  Erreur de résultat NULL, l'utilisateur n'a rien rentré dans la zone de texte.
     * @throws EmptyOperatorException Erreur d'opérateur NULL, impossible sauf modification de operatorGenerator dans EasyOperationGenerationService
     */
    public static boolean isEqual(@NonNull HardOperationModel hardModel, String submittedStringResult) throws EmptyResultException, EmptyOperatorException {

        int easyPartResult;
        try {
            easyPartResult = compute(hardModel);
        }catch (EmptyOperatorException e){
            throw e;
        }
        int first = hardModel.getFirstOperationMember();
        int second = hardModel.getSecondOperationMember();
        int third = hardModel.getThirdOperationMember();

        String secondOperator = hardModel.getSecondOperator();
        String firstOperator  = hardModel.getOperator();

        if(submittedStringResult.isEmpty()){
            throw new EmptyResultException("Answer cannot be null");
        }

        int submittedIntResult = Integer.parseInt(submittedStringResult);

        int operationResult;


        if(secondOperator.equals("*") && !firstOperator.equals("/") ){// Gestion des priorités d'opération
            operationResult = compute(second, secondOperator, third);
            operationResult = compute(first, firstOperator, operationResult);
        }
        else {
            operationResult = compute(easyPartResult, secondOperator, third);
        }

        return operationResult == submittedIntResult;
    }

    /**
     * Calcul le résultat d'une opération difficile passée en paramètre via un modèle
     * @param hardModel Modèle contenant les données de l'opération
     * @return Valeur entière, resultat de l'opération
     * @throws EmptyOperatorException Erreur d'opérateur NULL, impossible sauf modification de operatorGenerator dans EasyOperationGenerationService
     */
    public static int computeHard(@NonNull HardOperationModel hardModel) throws EmptyOperatorException {


        int easyPartResult = compute(hardModel);
        int first = hardModel.getFirstOperationMember();
        int second = hardModel.getSecondOperationMember();
        int third = hardModel.getThirdOperationMember();

        String secondOperator = hardModel.getSecondOperator();
        String firstOperator  = hardModel.getOperator();

        int operationResult;


        if(secondOperator.equals("*") && !firstOperator.equals("/")){// Gestion des priorités d'opération
            operationResult = compute(second, secondOperator, third);
            operationResult = compute(first, firstOperator, operationResult);
        }
        else {
            operationResult = compute(easyPartResult, secondOperator, third);
        }

        return operationResult;
    }

}
