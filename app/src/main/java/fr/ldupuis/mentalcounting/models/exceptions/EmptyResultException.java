package fr.ldupuis.mentalcounting.models.exceptions;

import androidx.annotation.Nullable;

public class EmptyResultException extends Exception{

    private String message;
    public EmptyResultException(String errorMessage){
        this.message = errorMessage;
    }

    @Nullable
    @Override
    public String getMessage() {
        return message;
    }
}
