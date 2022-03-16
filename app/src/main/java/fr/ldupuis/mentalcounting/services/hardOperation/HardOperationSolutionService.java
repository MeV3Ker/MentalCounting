package fr.ldupuis.mentalcounting.services.hardOperation;


import androidx.annotation.NonNull;

import fr.ldupuis.mentalcounting.models.EasyOperationModel;
import fr.ldupuis.mentalcounting.models.HardOperationModel;
import fr.ldupuis.mentalcounting.models.exceptions.EmptyResultException;

import static fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationSolutionService.compute;

public class HardOperationSolutionService {

    public static boolean isEqual(@NonNull HardOperationModel hardModel, String submittedStringResult)throws EmptyResultException{

        EasyOperationModel easyModel = hardModel.getEasyOperationModel();

        int easyPartResult = compute(easyModel);
        int first = hardModel.getFirstOperationMember();
        int second = hardModel.getSecondOperationMember();
        int third = hardModel.getThirdOperationMember();

        String secondOperator = hardModel.getSecondOperator();
        String firstOperator  = hardModel.getFirstOperator();

        if(submittedStringResult.isEmpty()){
            throw new EmptyResultException("Answer cannot be null");
        }

        int submittedIntResult = Integer.parseInt(submittedStringResult);

        int operationResult;


        if(secondOperator == "*" && firstOperator !="/" ){
            operationResult = compute(second, secondOperator, third);
            operationResult = compute(first, firstOperator, operationResult);
        }
        else {
            operationResult = compute(easyPartResult, secondOperator, third);
        }

        return operationResult == submittedIntResult;
    }

    public static int computeHard(@NonNull HardOperationModel hardModel){

        EasyOperationModel easyModel = hardModel.getEasyOperationModel();

        int easyPartResult = compute(easyModel);
        int first = hardModel.getFirstOperationMember();
        int second = hardModel.getSecondOperationMember();
        int third = hardModel.getThirdOperationMember();

        String secondOperator = hardModel.getSecondOperator();
        String firstOperator  = hardModel.getFirstOperator();

        int operationResult;


        if(secondOperator == "*" && firstOperator !="/" ){
            operationResult = compute(second, secondOperator, third);
            operationResult = compute(first, firstOperator, operationResult);
        }
        else {
            operationResult = compute(easyPartResult, secondOperator, third);
        }

        return operationResult;
    }



}
