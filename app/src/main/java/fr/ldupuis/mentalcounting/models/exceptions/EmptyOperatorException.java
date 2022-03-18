package fr.ldupuis.mentalcounting.models.exceptions;

import androidx.annotation.Nullable;

/**
 * Class de l'exception généré aléatoirment d'opérateur NULL
 */
public class EmptyOperatorException extends Exception {

    private String message;

    /**
     * Constructeur unique de l'exception
     * @param errorMessage Message d'erreur à afficher à l'utilisateur (hardcoded)
     */
    public EmptyOperatorException(String errorMessage){
        super(errorMessage);
    }

    /**
     * Getter du message d'erreur
     * @return Retourne le message d'erreur de l'exception
     */
    @Nullable
    @Override
    public String getMessage() {
        return message;
    }
}
