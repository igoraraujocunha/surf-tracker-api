package com.mvp.surf_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sessoes_surf")
public class SessaoSurf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String praia;
    private LocalDate dataSessao;
    private Double tamanhoOnda;
    private Integer nota;

    public SessaoSurf() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPraia() { return praia; }
    public void setPraia(String praia) { this.praia = praia; }

    public LocalDate getDataSessao() { return dataSessao; }
    public void setDataSessao(LocalDate dataSessao) { this.dataSessao = dataSessao; }

    public Double getTamanhoOnda() { return tamanhoOnda; }
    public void setTamanhoOnda(Double tamanhoOnda) { this.tamanhoOnda = tamanhoOnda; }

    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }
}