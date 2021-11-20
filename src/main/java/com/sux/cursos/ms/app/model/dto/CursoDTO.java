/*
 * Proyecto:        MS - CURSOS
 * A.J. SUX  – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.sux.cursos.ms.app.model.dto;

import java.util.Date;

/**
 * @name CursoDTO
 * @description Clase que encapsula la informacion perteneciente a un Curso.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 20/11/2021 16:03 hrs
 * @version 0.1
 */
public class CursoDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private Date createAt;


    public CursoDTO() {
    }

    public CursoDTO(Long id, String nombre, String descripcion, Date createAt) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.createAt = createAt;
    }


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

    @Override
    public String toString() {
        return "CursoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", createAt=" + createAt +
                '}';
    }

}
