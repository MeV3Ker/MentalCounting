package fr.ldupuis.mentalcounting.services.easyOperation;

import androidx.annotation.NonNull;

import fr.ldupuis.mentalcounting.models.EasyOperationModel;

public class EasyOperationSolutionService {

    public static boolean isEqual(@NonNull EasyOperationModel easyModel, int submittedResult){

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
                operationResult = first / second;
                break;
            default:
                //TODO result service, operation error
                operationResult = 0;
        }


        return operationResult == submittedResult;
    }

    public static int compute(EasyOperationModel easyModel){

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
                operationResult = first / second;
                break;
            default:
                //TODO result service, operation error
                operationResult = 0;
        }


        return operationResult;
    }

    public static int compute(int first, String operator, int second){

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
                operationResult = first / second;
                break;
            default:
                //TODO result service, operation error
                operationResult = 0;
        }


        return operationResult;
    }
}
