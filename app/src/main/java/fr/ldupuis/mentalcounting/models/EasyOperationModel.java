package fr.ldupuis.mentalcounting.models;

import androidx.annotation.NonNull;

import fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationGenerationService;

public class EasyOperationModel extends BaseEntity {
    private final int firstOperationMember;
    private final int secondOperationMember;
    private final String operator;

    public EasyOperationModel(@NonNull EasyOperationGenerationService generatedOperation) {

        this.firstOperationMember = generatedOperation.getFirstOperationMember();
        this.secondOperationMember = generatedOperation.getSecondOperationMember();
        this.operator = generatedOperation.getOperator();
    }

    public EasyOperationModel(int first, int second, String operator) {

        this.firstOperationMember = first;
        this.secondOperationMember = second;
        this.operator = operator;
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

}

