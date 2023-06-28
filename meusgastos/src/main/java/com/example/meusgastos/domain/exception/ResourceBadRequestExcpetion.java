package com.example.meusgastos.domain.exception;

public class ResourceBadRequestExcpetion extends RuntimeException{
    public ResourceBadRequestExcpetion(String mensagem){
        super(mensagem);
    }
}
