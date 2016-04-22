/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import rs.com.xucro.modelo.Aplicacao;
import rs.com.xucro.modelo.Categoria;

/**
 *
 * @author gustavo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "aplicativo")
public class Aplicativo extends Aplicacao implements Serializable{
 
    @NotBlank(message="Deve-se definir a imagem de icone do aplicativo")
    @Length(min=4,message = "Arquivo inválido")
    private String imagemIcone;
    
    @NotNull(message="Deve-se definir se o aplicativo deve ou não compartilhar informações")
    private boolean compartilhamentoInformacoes;
    
    @NotNull(message="O aplicativo deve conter uma categoria")
    @ManyToOne
    @JoinColumn(name="aplicativo",referencedColumnName = "id", nullable = false)
    private Categoria categoria;
    
     @ManyToMany
    @JoinTable(name = "bibliotecaAplicativo", 
            joinColumns = 
                    @JoinColumn(name = "aplicativo", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false))
    private List<Usuario> usuario = new ArrayList<>();
     
     

    public String getImagemIcone() {
        return imagemIcone;
    }

    public void setImagemIcone(String imagemIcone) {
        this.imagemIcone = imagemIcone;
    }

    public boolean isCompartilhamentoInformacoes() {
        return compartilhamentoInformacoes;
    }

    public void setCompartilhamentoInformacoes(boolean compartilhamentoInformacoes) {
        this.compartilhamentoInformacoes = compartilhamentoInformacoes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Aplicativo() {
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
    
}
