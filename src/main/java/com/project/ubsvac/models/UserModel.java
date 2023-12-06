package com.project.ubsvac.models;

import lombok.Data;
import jakarta.persistence.*;

@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    private String RG;

    @Column(unique = true)
    private String CPF;

    private String nascimento;

    private String sexo;

    private String celular;

    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "endereco_id")
     * private Endereco endereco;
     */
}
