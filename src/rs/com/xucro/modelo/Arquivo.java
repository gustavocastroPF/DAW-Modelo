/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "arquivo")
public class Arquivo implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_arquivo", sequenceName = "seq_arquivo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_arquivo", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "Erro ao definir o tamanho do arquivo")
    private Double tamanho;

    @NotNull(message = "A versão do arquivo deve ser definida")
    private Double versao;

    @NotBlank(message = "Erro ao definir o caminho do arquivo para upload")
    private String caminho;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataUpload;

    @NotNull(message = "A aplicação deve ser definida")
    @ManyToOne
    @JoinColumn(name = "aplicacao_id", referencedColumnName = "id", nullable = false)
    private Aplicacao aplicacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public Double getVersao() {
        return versao;
    }

    public void setVersao(Double versao) {
        this.versao = versao;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Calendar getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(Calendar dataUpload) {
        this.dataUpload = dataUpload;
    }

    public Aplicacao getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    public Arquivo() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Arquivo other = (Arquivo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Arquivo{" + "caminho=" + caminho + '}';
    }

}
