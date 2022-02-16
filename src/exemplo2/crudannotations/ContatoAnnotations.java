/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo2.crudannotations;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import exemplo2.conexao.HibernateUtil;
import java.util.Objects;

/**
 *
 * @author saimor
 */
@Entity
@Table(name = "contato")
public class ContatoAnnotations {
    @Id
    @GeneratedValue
    @Column(name = "codigo")
    private Integer codigo;
    
    @Column(name = "nome", length = 50, nullable = true)
    private String nome;
    
    @Column(name = "telefone", length = 50, nullable = true)
    private String telefone;
    
    @Column(name = "email", length = 50, nullable = true)
    private String email;
    
    @Column(name = "dt_cad", nullable = true)
    private Date dataCadastro;
    
    @Column(name = "obs", nullable = true)
    private String observacao;

    public ContatoAnnotations(Integer codigo, String nome, String telefone, String email, Date dataCadastro, String observacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.observacao = observacao;
    }

    ContatoAnnotations() {
        this.codigo = 0;
        this.nome = "";
        this.telefone = "";
        this.email = "";
        this.dataCadastro = null;
        this.observacao = "";
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "ContatoAnnotations{" + "codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", dataCadastro=" + dataCadastro + ", observacao=" + observacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigo);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.telefone);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.dataCadastro);
        hash = 89 * hash + Objects.hashCode(this.observacao);
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
        final ContatoAnnotations other = (ContatoAnnotations) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.dataCadastro, other.dataCadastro);
    }
    
    
    
}
