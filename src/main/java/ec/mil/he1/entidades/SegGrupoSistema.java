/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "SEG_GRUPO_SISTEMA")
@NamedQueries({
    @NamedQuery(name = "SegGrupoSistema.findAll", query = "SELECT s FROM SegGrupoSistema s")})
public class SegGrupoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRU_ID")
    private BigDecimal gruId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GRU_DESCRIPCION")
    private String gruDescripcion;
    @Column(name = "GRU_ESTADO")
    private Character gruEstado;
    @Column(name = "GRU_ORDEN_PRESENTACION")
    private BigInteger gruOrdenPresentacion;
    @Column(name = "GRU_ULTIMO_NIVEL")
    private Character gruUltimoNivel;
    @OneToMany(mappedBy = "segGrupoSistema", fetch = FetchType.LAZY)
    private List<SegOpcionMenu> segOpcionMenuList;
    @OneToMany(mappedBy = "segGrupoSistema", fetch = FetchType.LAZY)
    private List<SegGrupoSistema> segGrupoSistemaList;
    @JoinColumn(name = "GRU_ID_FK", referencedColumnName = "GRU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegGrupoSistema segGrupoSistema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segGrupoSistema", fetch = FetchType.LAZY)
    private List<SegPerfil> segPerfilList;

    public SegGrupoSistema() {
    }

    public SegGrupoSistema(BigDecimal gruId) {
        this.gruId = gruId;
    }

    public SegGrupoSistema(BigDecimal gruId, String gruDescripcion) {
        this.gruId = gruId;
        this.gruDescripcion = gruDescripcion;
    }

    public BigDecimal getGruId() {
        return gruId;
    }

    public void setGruId(BigDecimal gruId) {
        this.gruId = gruId;
    }

    public String getGruDescripcion() {
        return gruDescripcion;
    }

    public void setGruDescripcion(String gruDescripcion) {
        this.gruDescripcion = gruDescripcion;
    }

    public Character getGruEstado() {
        return gruEstado;
    }

    public void setGruEstado(Character gruEstado) {
        this.gruEstado = gruEstado;
    }

    public BigInteger getGruOrdenPresentacion() {
        return gruOrdenPresentacion;
    }

    public void setGruOrdenPresentacion(BigInteger gruOrdenPresentacion) {
        this.gruOrdenPresentacion = gruOrdenPresentacion;
    }

    public Character getGruUltimoNivel() {
        return gruUltimoNivel;
    }

    public void setGruUltimoNivel(Character gruUltimoNivel) {
        this.gruUltimoNivel = gruUltimoNivel;
    }

    public List<SegOpcionMenu> getSegOpcionMenuList() {
        return segOpcionMenuList;
    }

    public void setSegOpcionMenuList(List<SegOpcionMenu> segOpcionMenuList) {
        this.segOpcionMenuList = segOpcionMenuList;
    }

    public List<SegGrupoSistema> getSegGrupoSistemaList() {
        return segGrupoSistemaList;
    }

    public void setSegGrupoSistemaList(List<SegGrupoSistema> segGrupoSistemaList) {
        this.segGrupoSistemaList = segGrupoSistemaList;
    }

    public SegGrupoSistema getSegGrupoSistema() {
        return segGrupoSistema;
    }

    public void setSegGrupoSistema(SegGrupoSistema segGrupoSistema) {
        this.segGrupoSistema = segGrupoSistema;
    }

    public List<SegPerfil> getSegPerfilList() {
        return segPerfilList;
    }

    public void setSegPerfilList(List<SegPerfil> segPerfilList) {
        this.segPerfilList = segPerfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gruId != null ? gruId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegGrupoSistema)) {
            return false;
        }
        SegGrupoSistema other = (SegGrupoSistema) object;
        if ((this.gruId == null && other.gruId != null) || (this.gruId != null && !this.gruId.equals(other.gruId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.entidades.SegGrupoSistema[ gruId=" + gruId + " ]";
    }
    
}
