package fr.ldupuis.mentalcounting.services.hardOperation;

import fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationGenerationService;

/**
 * Class permettant de génerer aléatoirement une opération à trois termes
 */
public class HardOperationGenerationService extends EasyOperationGenerationService{

    private final static int HARD_UPPERBOUND = 95;// Valeur MAX d'un terme d'une opération difficile

    private int thirdOperationMember;
    private String secondOperator;

    /**
     * Générateur d'operation, le procédé est le même que pour EasyOperationGenerationService
     * Résultat d'opération toujours entier
     */
    public HardOperationGenerationService(){
        super(HARD_UPPERBOUND);
        thirdOperationMember = numberGenerator(HARD_UPPERBOUND);
        secondOperator = operatorGenerator(3);//Evite de devoir gérer le cas de 2 divisions à la suite
    }

    /**
     * Getter permettant de consulter le troisième membre de l'opération
     * @return Valeur du troisième membre de l'opération
     */
    public int getThirdOperationMember(){return thirdOperationMember;}

    /**
     * Getter permettant de consulter le second opérateur de l'opération
     * @return Valeur du second opérateur de l'opération
     */
    public String getSecondOperator(){ return secondOperator;}

}
