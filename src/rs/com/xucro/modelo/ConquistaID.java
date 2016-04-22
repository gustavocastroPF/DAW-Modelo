/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 *
 * @author gustavo
 */
@Embeddable
public class ConquistaID implements Serializable{
    
    @NotNull(message="O ID deve ser informado")
    @Column(name="id", nullable = false)
    @Min(value=1, message = "O ID dever ser maior ou igual a  {value}")
    private Integer id;
    
    @NotNull(message="O jogo deve ser informado")
    @ManyToOne
    @JoinColumn(name="jogo",referencedColumnName = "id",nullable = false)
    private Jogo jogo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public ConquistaID() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final ConquistaID other = (ConquistaID) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConquistaID{" + "id=" + id + '}';
    }
    
    
}
