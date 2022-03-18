package fr.ldupuis.mentalcounting.models;


import androidx.annotation.NonNull;

import fr.ldupuis.mentalcounting.services.hardOperation.HardOperationGenerationService;

/**
 * Class des modèles des opérations difficile, permet de stocker les opérations et de consulter les données des opérations.
 * Hérite de EasyOperationModel parce qu'une opération à 3 membres équivaut à une opération à 2 membres + un opérateur et un terme
 */
public class HardOperationModel extends EasyOperationModel {


    private final int thirdOperationMember;
    private final String secondOperator;

    /**
     * Crée un modèle difficile à partir d'un objet opération généré
     * @param hardOperation Objet opération contenant une opération difficile
     */
    public HardOperationModel(@NonNull HardOperationGenerationService hardOperation){
        super(hardOperation);

        this.thirdOperationMember = hardOperation.getThirdOperationMember();
        this.secondOperator = hardOperation.getSecondOperator();
    }

    /**
     * Crée un modèle difficile à partir des valeurs individuelles de chaque membres
     * @param first Entier contenant la valeur du premier terme de l'opération
     * @param second Entier contenant la valeur du second terme de l'opération
     * @param third Entier contenant la valeur du troisième terme de l'opération
     * @param operator Chaîne de caractère contenant le type de l'opérateur
     * @param secondOperator Chaîne de caractère contenant le type du second opérateur
     */
    public HardOperationModel(int first, int second, int third, String operator, String secondOperator) {
        super(first, second, operator);
        this.thirdOperationMember = third;
        this.secondOperator = secondOperator;
    }

    /**
     * Getter permettant de consulter le troisième membre de l'opération
     * @return Valeur du troisième membre de l'opération
     */
    public int getThirdOperationMember() {
        return thirdOperationMember;
    }

    /**
     * Getter permettant de consulter le second opérateur
     * @return Valeur du second opérateur
     */
    public String getSecondOperator(){
        return  secondOperator;
    }

}
