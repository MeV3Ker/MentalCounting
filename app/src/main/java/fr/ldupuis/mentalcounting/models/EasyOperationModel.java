package fr.ldupuis.mentalcounting.models;

import androidx.annotation.NonNull;

import fr.ldupuis.mentalcounting.models.entities.BaseEntity;
import fr.ldupuis.mentalcounting.services.easyOperation.EasyOperationGenerationService;

/**
 * Class des modèles des opérations facile, permet de stocker les opérations et de consulter les données des opérations
 */
public class EasyOperationModel extends BaseEntity {
    private final int firstOperationMember;
    private final int secondOperationMember;
    private final String operator;

    /**
     * Crée un modèle facile à partir d'un objet opération généré
     * @param generatedOperation Objet opération contenant une opération facile
     */
    public EasyOperationModel(@NonNull EasyOperationGenerationService generatedOperation) {

        this.firstOperationMember = generatedOperation.getFirstOperationMember();
        this.secondOperationMember = generatedOperation.getSecondOperationMember();
        this.operator = generatedOperation.getOperator();
    }

    /**
     * Crée un modèle facile à partir des valeurs individuelles de chaque membres
     * @param first Entier contenant la valeur du premier terme de l'opération
     * @param second Entier contenant la valeur du second terme de l'opération
     * @param operator Chaîne de caractère contenant le type de l'opérateur
     */
    public EasyOperationModel(int first, int second, String operator) {

        this.firstOperationMember = first;
        this.secondOperationMember = second;
        this.operator = operator;
    }

    /**
     * Getter permettant de consulter le premier membre de l'opération
     * @return Valeur du permier membre de l'opération
     */
    public int getFirstOperationMember() {
        return firstOperationMember;
    }

    /**
     * Getter permettant de consulter le second membre de l'opération
     * @return Valeur du second membre de l'opération
     */
    public int getSecondOperationMember() {
        return secondOperationMember;
    }

    /**
     * Getter permettant de consulter l'opérateur
     * @return Type d'opération
     */
    public String getOperator() {
        return operator;
    }

}

