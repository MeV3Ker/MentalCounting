package fr.ldupuis.mentalcounting.models.entities;

/**
 * Valeurs à inclure dans la BDD. Chaque variable correspond à une colonne.
 */
public class EasyOperationEntity extends BaseEntity {
    public int firstMember;
    public int secondMember;
    public String operator;
}
