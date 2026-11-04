package com.wallacecarlos.Usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
@Builder

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long  id;
    @Column(name = "Rua")
    private String rua;
    @Column(name = "numero")
    private String numero;
    @Column (name = "complemento", length = 10)
    private String complemento;
    @Column (name = "cidade")
    private String cidade;
    @Column(name = "estado",length = 2)
    private String estado;
    @Column(name = "cep",length = 9)
    private String cep;








}
