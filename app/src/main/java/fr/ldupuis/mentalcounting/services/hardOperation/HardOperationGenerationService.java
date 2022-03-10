package fr.ldupuis.mentalcounting.services.hardOperation;

import fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationGenerationService;

public class HardOperationGenerationService extends EasyOperationGenerationService{
    private final int HARD_UPPERBOUND = 95;

    private EasyOperationGenerationService generatedEasyOperation;
    private int thirdOperationMember;
    private String secondOperator;

    public HardOperationGenerationService(){
        generatedEasyOperation = new EasyOperationGenerationService();
        thirdOperationMember = numberGenerator(HARD_UPPERBOUND);
        secondOperator = operatorGenerator(3);
    }

    public int getThirdOperationMember(){return thirdOperationMember;}

    public String getSecondOperator(){ return secondOperator;}

    public EasyOperationGenerationService getGeneratedEasyOperation(){ return generatedEasyOperation;}

}
