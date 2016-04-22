/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "conquista")
public class Conquista implements Serializable {

    @EmbeddedId
    private ConquistaID conquistaID;

    @NotBlank(message = "A conquista deve conter uma descrição")
    @Length(min = 20, message = "A descrição da conquista deve conter no mínimo {min} caracteres")
    private String descricao;

    @NotBlank(message = "Erro ao realizar o upload da imagem")
    @Length(min = 4, message = "Formato de imagem inválido")
    private String imagem;

    @NotNull(message = "Uma conquista deve conter um valor de pontuação relacionado a ela")
    private Double pontuacao;

    @NotNull(message = "Deve-se informar o status da conquista")
    private boolean status;

    public ConquistaID getConquistaID() {
        return conquistaID;
    }

    public void setConquistaID(ConquistaID conquistaID) {
        this.conquistaID = conquistaID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Conquista() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.conquistaID);
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
        final Conquista other = (Conquista) obj;
        if (!Objects.equals(this.conquistaID, other.conquistaID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conquista{" + "descricao=" + descricao + '}';
    }
    
    

}
