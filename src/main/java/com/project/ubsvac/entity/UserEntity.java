package com.project.ubsvac.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Table(name = "usuario")
@Entity
public class UserEntity {

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

    // Construtores podem ser gerados automaticamente pelo Lombok

    // getters e setters são gerados automaticamente pelo Lombok
}
