package fr.ldupuis.mentalcounting.models;

import android.os.Parcelable;

import androidx.annotation.NonNull;

import fr.ldupuis.mentalcounting.services.hardOperation.HardOperationGenerationService;

public class HardOperationModel {

    private final EasyOperationModel easyOperationModel;
    private final int thirdOperationMember;
    private final String secondOperator;

    public HardOperationModel(@NonNull HardOperationGenerationService hardOperation){

        easyOperationModel = new EasyOperationModel(hardOperation.getGeneratedEasyOperation());

        this.thirdOperationMember = hardOperation.getThirdOperationMember();
        this.secondOperator = hardOperation.getSecondOperator();
    }

    public int getFirstOperationMember(){
        return easyOperationModel.getFirstOperationMember();
    }

    public int getSecondOperationMember(){
        return easyOperationModel.getSecondOperationMember();
    }

    public String getFirstOperator(){
        return easyOperationModel.getOperator();
    }

    public int getThirdOperationMember() {
        return thirdOperationMember;
    }

    public String getSecondOperator(){
        return  secondOperator;
    }

    public EasyOperationModel getEasyOperationModel() {return easyOperationModel; };

    @NonNull
    @Override
    public String toString() {
        String operation;

        operation = easyOperationModel.toString() + getSecondOperator() + getThirdOperationMember();
        return operation;
    }
}
