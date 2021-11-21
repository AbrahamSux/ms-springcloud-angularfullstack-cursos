/*
 * Proyecto:        MS - CURSOS
 * A.J. SUX  – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.sux.cursos.ms.app.model.dto;

import java.util.Date;
import java.util.Objects;

/**
 * @name AlumnoDTO
 * @description Clase que encapsula la informacion perteneciente a un Alumno.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 21/11/2021 09:59 hrs
 * @version 0.1
 */
public class AlumnoDTO {

    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private Date createAt;

    public AlumnoDTO() {
    }

    public AlumnoDTO(Long id, String nombre, String apellidoPaterno, String apellidoMaterno,
                     String email, Date createAt) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidoPaterno, apellidoMaterno, email);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlumnoDTO)) {
            return false;
        }

        final AlumnoDTO other = (AlumnoDTO) obj;
        return (this.hashCode() == other.hashCode());
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" +
                "idAlumno=" + id +
                ", nombreAlumno='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", emailAlumno='" + email + '\'' +
                ", createAtAlumno=" + createAt +
                '}';
    }

}
