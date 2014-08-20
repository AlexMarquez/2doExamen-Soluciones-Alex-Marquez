/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author T-10A
 */
@Entity
@Table(name = "calificacion")

public class Calificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calificacion")
    private Integer idCalificacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "examen_parcial")
    private Float examenParcial;
    @Column(name = "examen_final")
    private Float examenFinal;
    @Column(name = "total")
    private Float total;
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    @ManyToOne
    private Alumno idAlumno;

    public Calificacion() {
    }

    public Calificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Calificacion(Float examenParcial, Float examenFinal, Float total, Alumno idAlumno) {
        this.examenParcial = examenParcial;
        this.examenFinal = examenFinal;
        this.total = total;
        this.idAlumno = idAlumno;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Float getExamenParcial() {
        return examenParcial;
    }

    public void setExamenParcial(Float examenParcial) {
        this.examenParcial = examenParcial;
    }

    public Float getExamenFinal() {
        return examenFinal;
    }

    public void setExamenFinal(Float examenFinal) {
        this.examenFinal = examenFinal;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificacion != null ? idCalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.idCalificacion == null && other.idCalificacion != null) || (this.idCalificacion != null && !this.idCalificacion.equals(other.idCalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.campitos.spring.web.Calificacion[ idCalificacion=" + idCalificacion + " ]";
    }
    
}
