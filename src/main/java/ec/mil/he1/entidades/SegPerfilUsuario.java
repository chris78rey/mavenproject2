/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "SEG_PERFIL_USUARIO")
@NamedQueries({
    @NamedQuery(name = "SegPerfilUsuario.findAll", query = "SELECT s FROM SegPerfilUsuario s")})
public class SegPerfilUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEU_ID")
    private BigDecimal peuId;
    @Column(name = "PEU_ESTADO")
    private Character peuEstado;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SegPerfil segPerfil;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SegUsuario segUsuario;

    public SegPerfilUsuario() {
    }

    public SegPerfilUsuario(BigDecimal peuId) {
        this.peuId = peuId;
    }

    public BigDecimal getPeuId() {
        return peuId;
    }

    public void setPeuId(BigDecimal peuId) {
        this.peuId = peuId;
    }

    public Character getPeuEstado() {
        return peuEstado;
    }

    public void setPeuEstado(Character peuEstado) {
        this.peuEstado = peuEstado;
    }

    public SegPerfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(SegPerfil segPerfil) {
        this.segPerfil = segPerfil;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peuId != null ? peuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPerfilUsuario)) {
            return false;
        }
        SegPerfilUsuario other = (SegPerfilUsuario) object;
        if ((this.peuId == null && other.peuId != null) || (this.peuId != null && !this.peuId.equals(other.peuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.entidades.SegPerfilUsuario[ peuId=" + peuId + " ]";
    }
    
}
