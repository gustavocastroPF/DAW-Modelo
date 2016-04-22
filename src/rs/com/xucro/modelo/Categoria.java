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
@Table(name = "Categoria")
public class Categoria {
    
    @Id
    @SequenceGenerator(name="seq_categoria",sequenceName = "seq_categoria_id", allocationSize = 1)
    @GeneratedValue(generator="seq_categoria",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome da categoria deve ser definida")
    @Length(min = 3,max=30,message = "O nome da categoria deve conter entre {max} e {min} caracteres.")
    private String nome;
    
    @NotBlank(message = "O nome da categoria deve ser definida")
    @Length(min = 10, max=100,message = "A descrição da categoria deve conter entre {max} e {min} caracteres.")
    private String descricao;
    
    @NotBlank(message = "Erro ao tentar definir o caminho da imagem.")
    @Length(min = 4, message = "Imagem inválida.")
    private String imagem;
    
    @NotNull(message = "O status da categoria deve ser definido")
    private boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Categoria() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
