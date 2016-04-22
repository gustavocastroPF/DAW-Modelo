/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.modelo;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name="imagem")
public class Imagem {
    
    @Id
    @SequenceGenerator(name="seq_imagem",sequenceName = "seq_imagem_id",allocationSize = 1)
    @GeneratedValue(generator ="seq_imagem" ,strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="Erro ao realizar o upload da imagem")
    @Length(min=4,message="Arquivo inválido")
    private String caminho;
    
    @NotBlank(message="A imagem deve conter uma descrição")
    @Length(min=8, message="A descrição deve conter no mínimo {min} caracteres" )  
    private String descricao;
    
    @NotNull(message="Impossível obter o tamanho do arquivo")
    private Double tamanho;
    
    @NotNull(message="O status da imagem deve ser definido")
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name = "aplicativo", referencedColumnName = "id", nullable = false)
    private Aplicativo aplicativo;
    
    @ManyToOne
    @JoinColumn(name = "jogo", referencedColumnName = "id", nullable = false)
    private Jogo jogo;
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }
    
    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Imagem() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Imagem other = (Imagem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagem{" + "descricao=" + descricao + '}';
    }

    
    
    
    
}
