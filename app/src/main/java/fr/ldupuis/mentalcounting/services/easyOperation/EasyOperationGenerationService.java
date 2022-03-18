package fr.ldupuis.mentalcounting.services.easyOperation;

import java.util.Random;

/**
 * Class permettant de générer aléatoirement une opération à deux termes.
 *
 */
public class EasyOperationGenerationService {

    private final int firstOperationMember;
    private final int secondOperationMember;
    private String operator;

    /**
     * Génération d'une opération, le résultat de l'opération est obligatoirement entier
     */
    public EasyOperationGenerationService(int upperBound){

        this.operator = operatorGenerator(4);
        //Traitement avec l'opérateur diviser pour obtenir obligatpirement un résultat final entier, devient pseudo-aléatoire
        if(operator.equals("/")) {
            this.secondOperationMember = numberGenerator(upperBound);
            this.firstOperationMember = numberGenerator(upperBound) * this.secondOperationMember;
        }
        else{
            this.firstOperationMember = numberGenerator(upperBound);
            this.secondOperationMember = numberGenerator(upperBound);
        }

    }

    // Méthodes

    /**
     * Génère un opérateur à partir d'un entier aléatoire
     * @param upperbound Borne maximale du générateur aléatoire
     * @return Un String contenant l'opérateur
     */
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

    /**
     * Génère les premier et second terme de l'opération
     * @param max_value borne maximale du générateur aléatoire
     * @return Valeur du premier ou du secind terme
     */
    public int numberGenerator(int max_value){
        int generated_val;

        Random generator = new Random();
        //DON'T TOUCH
        generated_val = generator.nextInt(max_value) + 1;//Ne génère jamais 0, évite les divisions par 0

        return generated_val;
    }


    //Accesseurs
    /**
     * Getter permettant de consulter le premier membre de l'opération
     * @return Valeur du permier membre de l'opération
     */
    public int getFirstOperationMember(){ return firstOperationMember;}

    /**
     * Getter permettant de consulter le second membre de l'opération
     * @return Valeur du second membre de l'opération
     */
    public int getSecondOperationMember(){ return secondOperationMember;}

    /**
     * Getter permettant de consulter l'opérateur
     * @return Type d'opération
     */
    public String getOperator() { return operator;}

}
