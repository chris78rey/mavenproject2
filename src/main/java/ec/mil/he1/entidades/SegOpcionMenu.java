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
@Table(name = "SEG_OPCION_MENU")
@NamedQueries({
    @NamedQuery(name = "SegOpcionMenu.findAll", query = "SELECT s FROM SegOpcionMenu s")})
public class SegOpcionMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPC_ID")
    private BigDecimal opcId;
    @Size(max = 100)
    @Column(name = "OPC_NOMBRE_OPCION")
    private String opcNombreOpcion;
    @Column(name = "OPC_NIVEL")
    private BigInteger opcNivel;
    @Column(name = "OPC_ULTIMO_NIVEL")
    private Character opcUltimoNivel;
    @Column(name = "OPC_ORDEN_PRESENTACION")
    private BigInteger opcOrdenPresentacion;
    @Size(max = 4000)
    @Column(name = "OPC_URL")
    private String opcUrl;
    @Column(name = "OPC_ESTADO")
    private Character opcEstado;
    @OneToMany(mappedBy = "segOpcionMenu", fetch = FetchType.LAZY)
    private List<SegOpcionPerfil> segOpcionPerfilList;
    @JoinColumn(name = "GRU_ID", referencedColumnName = "GRU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegGrupoSistema segGrupoSistema;
    @OneToMany(mappedBy = "segOpcionMenu", fetch = FetchType.LAZY)
    private List<SegOpcionMenu> segOpcionMenuList;
    @JoinColumn(name = "OPC_ID_FK", referencedColumnName = "OPC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegOpcionMenu segOpcionMenu;

    public SegOpcionMenu() {
    }

    public SegOpcionMenu(BigDecimal opcId) {
        this.opcId = opcId;
    }

    public BigDecimal getOpcId() {
        return opcId;
    }

    public void setOpcId(BigDecimal opcId) {
        this.opcId = opcId;
    }

    public String getOpcNombreOpcion() {
        return opcNombreOpcion;
    }

    public void setOpcNombreOpcion(String opcNombreOpcion) {
        this.opcNombreOpcion = opcNombreOpcion;
    }

    public BigInteger getOpcNivel() {
        return opcNivel;
    }

    public void setOpcNivel(BigInteger opcNivel) {
        this.opcNivel = opcNivel;
    }

    public Character getOpcUltimoNivel() {
        return opcUltimoNivel;
    }

    public void setOpcUltimoNivel(Character opcUltimoNivel) {
        this.opcUltimoNivel = opcUltimoNivel;
    }

    public BigInteger getOpcOrdenPresentacion() {
        return opcOrdenPresentacion;
    }

    public void setOpcOrdenPresentacion(BigInteger opcOrdenPresentacion) {
        this.opcOrdenPresentacion = opcOrdenPresentacion;
    }

    public String getOpcUrl() {
        return opcUrl;
    }

    public void setOpcUrl(String opcUrl) {
        this.opcUrl = opcUrl;
    }

    public Character getOpcEstado() {
        return opcEstado;
    }

    public void setOpcEstado(Character opcEstado) {
        this.opcEstado = opcEstado;
    }

    public List<SegOpcionPerfil> getSegOpcionPerfilList() {
        return segOpcionPerfilList;
    }

    public void setSegOpcionPerfilList(List<SegOpcionPerfil> segOpcionPerfilList) {
        this.segOpcionPerfilList = segOpcionPerfilList;
    }

    public SegGrupoSistema getSegGrupoSistema() {
        return segGrupoSistema;
    }

    public void setSegGrupoSistema(SegGrupoSistema segGrupoSistema) {
        this.segGrupoSistema = segGrupoSistema;
    }

    public List<SegOpcionMenu> getSegOpcionMenuList() {
        return segOpcionMenuList;
    }

    public void setSegOpcionMenuList(List<SegOpcionMenu> segOpcionMenuList) {
        this.segOpcionMenuList = segOpcionMenuList;
    }

    public SegOpcionMenu getSegOpcionMenu() {
        return segOpcionMenu;
    }

    public void setSegOpcionMenu(SegOpcionMenu segOpcionMenu) {
        this.segOpcionMenu = segOpcionMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcId != null ? opcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegOpcionMenu)) {
            return false;
        }
        SegOpcionMenu other = (SegOpcionMenu) object;
        if ((this.opcId == null && other.opcId != null) || (this.opcId != null && !this.opcId.equals(other.opcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.entidades.SegOpcionMenu[ opcId=" + opcId + " ]";
    }
    
}
