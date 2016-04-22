/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gustavo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "autor")
public class Autor extends Usuario implements Serializable{
    
    @NotBlank(message = "O site do desenvolvedor deve ser definido")
    private String siteAutorDesenvolvedor;
    
    @NotBlank(message = "A rede social do desenvolvedor deve ser definido")
    private String redeSocial;
    
    private String siteDistribuidor;
    
    @NotNull(message = "O autor deve ser como distribuidor ou não distribuidor")
    private boolean distribuidor;

    public String getSiteAutorDesenvolvedor() {
        return siteAutorDesenvolvedor;
    }

    public void setSiteAutorDesenvolvedor(String siteAutorDesenvolvedor) {
        this.siteAutorDesenvolvedor = siteAutorDesenvolvedor;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public String getSiteDistribuidor() {
        return siteDistribuidor;
    }

    public void setSiteDistribuidor(String siteDistribuidor) {
        this.siteDistribuidor = siteDistribuidor;
    }

    public boolean isDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(boolean distribuidor) {
        this.distribuidor = distribuidor;
    }

    public Autor() {
    }
    
}
