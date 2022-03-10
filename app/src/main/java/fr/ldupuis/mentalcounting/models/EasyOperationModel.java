package fr.ldupuis.mentalcounting.models;

import androidx.annotation.NonNull;

import fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationGenerationService;

public class EasyOperationModel {
    private final int firstOperationMember;
    private final int secondOperationMember;
    private final String operator;

    public EasyOperationModel(@NonNull EasyOperationGenerationService generatedOperation) {

        this.firstOperationMember = generatedOperation.getFirstOperationMember();
        this.secondOperationMember = generatedOperation.getSecondOperationMember();
        this.operator = generatedOperation.getOperator();
    }

    public int getFirstOperationMember() {
        return firstOperationMember;
    }

    public int getSecondOperationMember() {
        return secondOperationMember;
    }

    public String getOperator() {
        return operator;
    }

    @NonNull
    @Override
    public String toString() {
        String operation;
        operation = getFirstOperationMember() + getOperator() + getSecondOperationMember();
        return operation;
    }
}

