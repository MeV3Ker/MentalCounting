package fr.ldupuis.mentalcounting.models.exceptions;

import androidx.annotation.Nullable;

/**
 * Class de l'exception en cas de saisi vide par l'utilisateur
 */
public class EmptyResultException extends Exception{

    private String message;

    /**
     * Constructeur unique de l'exception
     * @param errorMessage Message d'erreur à afficher à l'utilisateur (hardcoded)
     */
    public EmptyResultException(String errorMessage){
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
