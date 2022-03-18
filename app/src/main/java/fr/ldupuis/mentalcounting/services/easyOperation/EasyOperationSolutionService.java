package fr.ldupuis.mentalcounting.services.easyOperation;

import androidx.annotation.NonNull;

import fr.ldupuis.mentalcounting.models.EasyOperationModel;
import fr.ldupuis.mentalcounting.models.exceptions.EmptyResultException;

public class EasyOperationSolutionService {

    public static boolean isEqual(@NonNull EasyOperationModel easyModel, String submittedStringResult) throws ArithmeticException, EmptyResultException {

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
                //TODO result service, operation error
                operationResult = 0;
        }


        return operationResult == submittedIntResult;
    }

    public static int compute(EasyOperationModel easyModel) throws ArithmeticException{

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
                }catch (ArithmeticException e){
                    e = new ArithmeticException("Cannot divide by 0");
                    throw e;
                }

                break;
            default:
                //TODO result service, operation error
                operationResult = 0;
        }


        return operationResult;
    }

    public static int compute(int first, String operator, int second) throws ArithmeticException{

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
                }catch (ArithmeticException e){
                    e = new ArithmeticException("Cannot divide by 0");
                    throw e;
                }

                break;
            default:
                //TODO result service, operation error
                operationResult = 0;
        }


        return operationResult;
    }
}
