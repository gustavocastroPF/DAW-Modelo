package rs.com.xucro.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "aplicacao")
public abstract class Aplicacao implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_aplicacao", sequenceName = "seq_aplicacao_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aplicacao", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O nome da aplicação deve ser definida")
    @Length(min = 5, max = 50, message = "O nome da aplicação deve conter entre {min} e {max} caracteres")
    private String nome;

    @NotBlank(message = "Deve-se descrever um pouco da aplicação")
    @Length(min = 10, message = "A sinopse da aplicação deve conter no mínimo {min} caracteres")
    private String sinopse;

    @NotBlank(message = "Deve-se definir uma classificação indicativa para a aplicação")
    @Length(min = 2, message = "A classificação indicativa deve conter no mínimo {min} caracteres")
    private String classificacaoIndicativa;

    @NotBlank(message = "Não foi possivel encontrar o caminho para realizar o upload do manual")
    @Length(min = 4, message = "Tipo de arquivo inválido")
    private String manual;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "A data de upload deve ser definida")
    private Calendar dataUpload;

    @NotNull(message = "Não foi possível calcular o tamanho total da aplicação")
    private Double tamanhoTotal;

    @NotNull(message = "O status da aplicação deve ser definida")
    private boolean status;

    @NotNull(message = "Não foi possível calcular o número de downloads")
    private long downloads;

    @OneToMany(mappedBy = "aplicacao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Arquivo> Arquivos = new ArrayList<>();

    @NotNull(message = "O autor deve ser definido")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    private Autor autor;

    public void adicionarArquivo(Arquivo obj) {
        obj.setAplicacao(this);
        this.Arquivos.add(obj);
    }

    public void removerArquivo(int index) {
        this.Arquivos.remove(index);
    }

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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public Calendar getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(Calendar dataUpload) {
        this.dataUpload = dataUpload;
    }

    public Double getTamanhoTotal() {
        return tamanhoTotal;
    }

    public void setTamanhoTotal(Double tamanhoTotal) {
        this.tamanhoTotal = tamanhoTotal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getDownloads() {
        return downloads;
    }

    public void setDownloads(long downloads) {
        this.downloads = downloads;
    }

    public List<Arquivo> getArquivos() {
        return Arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.Arquivos = arquivos;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Aplicacao() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Aplicacao other = (Aplicacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aplicacao{" + "nome=" + nome + '}';
    }

}
