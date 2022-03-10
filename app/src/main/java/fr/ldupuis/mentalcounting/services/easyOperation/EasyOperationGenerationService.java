package fr.ldupuis.mentalcounting.services.easyOperation;

import java.util.Random;

public class EasyOperationGenerationService {
    private static final int EASY_UPPERBOUND = 12;

    private final int firstOperationMember;
    private final int secondOperationMember;
    private String operator;

    public EasyOperationGenerationService(){

        this.operator = operatorGenerator(4);

        if(operator.equals("/")) {
            this.secondOperationMember = numberGenerator(EASY_UPPERBOUND);
            this.firstOperationMember = numberGenerator(EASY_UPPERBOUND) * this.secondOperationMember;
        }
        else{
            this.firstOperationMember = numberGenerator(EASY_UPPERBOUND);
            this.secondOperationMember = numberGenerator(EASY_UPPERBOUND);
        }

    }
    // Méthodes
    public String operatorGenerator(int upperbound){
        int rand_value;

        rand_value = numberGenerator(upperbound);

        switch (rand_value) {
            case 1:
                operator = "+";
                break;
            case 2:
                operator = "-";
                break;
            case 3:
                operator = "*";
                break;
            case 4:
                operator = "/";
                break;
            default:
                operator = "+";
        }
        return operator;


    }

    public int numberGenerator(int max_value){
        int generated_val;

        Random generator = new Random();
        generated_val = generator.nextInt(max_value) + 1;

        return generated_val;
    }


    //Accesseurs
    public int getFirstOperationMember(){ return firstOperationMember;}

    public int getSecondOperationMember(){ return secondOperationMember;}

    public String getOperator() { return operator;}

}
