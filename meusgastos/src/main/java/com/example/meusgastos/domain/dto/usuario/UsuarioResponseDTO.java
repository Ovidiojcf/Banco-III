package com.example.meusgastos.domain.dto.usuario;

import javax.xml.crypto.Data;

public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private Data dataCadastro;
    private Data dataInativacao;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public Data getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Data dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public Data getDataInativacao() {
        return dataInativacao;
    }
    public void setDataInativacao(Data dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    
    
}
