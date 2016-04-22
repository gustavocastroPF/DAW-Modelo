/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "jogo")
public class Jogo extends Aplicacao implements Serializable {

    @NotBlank(message = "Erro ao carregar a imagem de capa do jogo")
    @Length(min = 4, message = "Formato de imagem inválido")
    private String imagemCapa;

    @NotNull(message = "Deve-se informar o número máximo de player do jogo")
    private Integer numeroPlayers;

    @NotNull(message = "Informe o número de bits de imagem do jogo. ex(8,16,32,64)")
    private Integer bits;

    @NotNull(message = "Defina se o jogo é a versão premium ou não")
    private boolean premium;

    @NotNull(message = "Defina se o jogo possui suporte online ou não")
    private boolean online;
    
    @NotNull(message = "O jogo deve conter uma categoria")
    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "id", nullable = false)
    private Categoria categoria;
    
    @OneToMany(mappedBy = "conquistaID.jogo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Conquista> conquistas = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "bibliotecaJogo",
            joinColumns
            = @JoinColumn(name = "jogo", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false))
    private List<Usuario> players = new ArrayList<>();

    public String getImagemCapa() {
        return imagemCapa;
    }

    public void setImagemCapa(String imagemCapa) {
        this.imagemCapa = imagemCapa;
    }

    public Integer getNumeroPlayers() {
        return numeroPlayers;
    }

    public void setNumeroPlayers(Integer numeroPlayers) {
        this.numeroPlayers = numeroPlayers;
    }

    public Integer getBits() {
        return bits;
    }

    public void setBits(Integer bits) {
        this.bits = bits;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Conquista> getConquistas() {
        return conquistas;
    }

    public void setConquistas(List<Conquista> conquistas) {
        this.conquistas = conquistas;
    }

    public List<Usuario> getPlayers() {
        return players;
    }

    public void setPlayers(List<Usuario> players) {
        this.players = players;
    }

    public Jogo() {
    }

}
