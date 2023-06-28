package com.example.meusgastos.domain.Enum;

public enum ETipoTitulo {
    ARECEBER ("A receber"),
    APAGAR ("A apagar");
     
    private String valor;

    private ETipoTitulo(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }

}
