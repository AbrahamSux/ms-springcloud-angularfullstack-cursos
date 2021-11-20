/*
 * Proyecto:        MS - CURSOS
 * A.J. SUX  – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.sux.cursos.ms.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

/**
 * @name Curso
 * @description Entidad que representa a un Curso dentro del sistema.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 20/11/2021 16:00 hrs.
 */
@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    private static final long serialVersionUID = -1962572630726401846L;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;



    // MÉTODOS

    @PrePersist
    void prePersist() {
        this.createAt = new Date();
    }



    // GETTERS Y SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

}
