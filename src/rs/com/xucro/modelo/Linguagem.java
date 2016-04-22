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
@Table(name="linguagem")
public class Linguagem {
    @Id
    @SequenceGenerator(name = "seq_linguagem", sequenceName = "seq_linguagem_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_linguagem", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="Defina um nome para o idioma")
    @Length(min=3,message = "O idioma deve conter no minimo {min} caracteres")
    private String idioma;
   
    @NotNull(message="O audio deve ser definido")
    private boolean audio;
    
    @NotNull(message="A legenda deve ser definida")
    private boolean legenda;
    
    @NotNull(message="A interface deve ser definida")
    private boolean interfaceG;
    
    @NotNull(message="O status deve ser definido")
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name = "jogo", referencedColumnName = "id", nullable = false)
    private Jogo jogo;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isAudio() {
        return audio;
    }

    public void setAudio(boolean audio) {
        this.audio = audio;
    }

    public boolean isLegenda() {
        return legenda;
    }

    public void setLegenda(boolean legenda) {
        this.legenda = legenda;
    }

    public boolean isInterfaceG() {
        return interfaceG;
    }

    public void setInterfaceG(boolean interfaceG) {
        this.interfaceG = interfaceG;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Linguagem() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Linguagem other = (Linguagem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Linguagem{" + "idioma=" + idioma + '}';
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
    
    
}
