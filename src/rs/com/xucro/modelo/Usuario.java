/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gustavo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="usuario")
public class Usuario implements Serializable{
    @Id
    @SequenceGenerator(name="seq_usuario",sequenceName = "seq_usuario_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="O login deve ser preenchido")
    @Length(min=7,message = "O login deve conter no mínimo {min} caracteres")
    private String login;
    
    @NotBlank(message="A senha deve ser preenchida")
    @Length(min=7,message = "A senha deve conter no mínimo {min} caracteres")
    private String senha;
    
    @NotBlank(message="O nome deve ser preenchido")
    @Length(min=7,message = "O nome deve conter no mínimo {min} caracteres")
    private String nome;
    
    @NotBlank(message="Erro ao definir imagem")
    @Length(min=4,message = "Imagem inválida")
    private String imagem;
    
    @NotBlank(message="O e-mail deve ser definido")
    @Length(min=7, message="O e-mail deve conter no mínimo {min} caracteres")
    private String email;
    
    @NotNull(message="O status deve ser informado")
    private boolean status;
    
    @NotNull(message="O usuário deve ser definido como adm ou cliente")
    private boolean administrador;
    
    @NotNull(message="A data de nascimento deve ser informada")
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    
    @ManyToMany
    @JoinTable(name = "bibliotecaJogo", 
            joinColumns = 
                    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "jogo", referencedColumnName = "id", nullable = false))
    private List<Jogo> jogos = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "bibliotecaAplicativo", 
            joinColumns = 
                    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "aplicativo", referencedColumnName = "id", nullable = false))
    private List<Aplicativo> aplicativo = new ArrayList<>();
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Usuario() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + '}';
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
    
    
    
}
