package com.gabriel.provaDeSuficiencia.models.DTO;

public class UsuarioDTO {
    private Long idUsuario;
    private String nomeUsuario;
    private String telefoneUsuario;

    public UsuarioDTO(){}

    public UsuarioDTO(Long idUsuario, String nomeUsuario, String telefoneUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.telefoneUsuario = telefoneUsuario;
    }
    
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }
    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }
}
