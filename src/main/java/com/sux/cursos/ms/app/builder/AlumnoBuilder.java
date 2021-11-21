/*
 * Proyecto:        MS - CURSOS
 * A.J. SUX  – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.sux.cursos.ms.app.builder;

import com.sux.cursos.ms.app.model.dto.AlumnoDTO;
import com.sux.cursos.ms.app.model.entity.Alumno;

import java.util.ArrayList;
import java.util.List;

/**
 * @name AlumnoBuilder
 * @description Builder que se encaraga de fabricar objetos Entity a partir de objetos DTO y viceversa.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 21/11/2021 10:14 hrs
 * @version 0.1
 */
public class AlumnoBuilder {



    public AlumnoBuilder() {
    }

    
    /**
     * Método que construye una lista de objetos de tipo AlumnoDTO a partir de una lista de objetos de tipo Alumno.
     *
     * @param alumnoList Lista de Alumnos de tipo Entity.
     * @return Lista de Alumnos de tipo DTO.
     */
    public static List<AlumnoDTO> buildAlumnoDTOListFromAlumnoList(List<Alumno> alumnoList) {
        List<AlumnoDTO> alumnosDTOList = null;

        if (null != alumnoList) {
            alumnosDTOList = new ArrayList<>();
            for (Alumno alumno : alumnoList) {
                alumnosDTOList.add(buildAlumnoDTOFromAlumno(alumno));
            }
        }

        return alumnosDTOList;
    }

    /**
     * Método que construye una lista de objetos de tipo Alumno a partir de una lista de objetos de tipo AlumnoDTO.
     *
     * @param alumnoDTOList Lista de Alumnos de tipo DTO.
     * @return Lista de Alumnos de tipo Entity.
     */
    public static List<Alumno> buildAlumnoListFromAlumnoDTOList(List<AlumnoDTO> alumnoDTOList) {
        List<Alumno> alumnoList = null;

        if (alumnoDTOList != null) {
            alumnoList = new ArrayList<>();
            for (AlumnoDTO alumnoDTO : alumnoDTOList) {
                alumnoList.add( buildAlumnoFromAlumnoDTO(alumnoDTO) );
            }
        }

        return alumnoList;
    }

    /**
     * Método que convierte de un entity de tipo Alumno a un objeto de tipo AlumnoDTO.
     *
     * @param alumno Entidad Alumno.
     * @return Objeto AlumnoDTO.
     */
    public static AlumnoDTO buildAlumnoDTOFromAlumno(Alumno alumno) {
        AlumnoDTO alumnoDTO = null;

        if (null != alumno) {
            alumnoDTO = new AlumnoDTO();
            alumnoDTO.setId(alumno.getId());
            alumnoDTO.setNombre(alumno.getNombre());
            alumnoDTO.setApellidoPaterno(alumno.getApellidoPaterno());
            alumnoDTO.setApellidoMaterno(alumno.getApellidoMaterno());
            alumnoDTO.setEmail(alumno.getEmail());
            alumnoDTO.setCreateAt(alumno.getCreateAt());
        }

        return alumnoDTO;
    }

    /**
     * Método que construye un entity Alumno a partir de un objeto tipo AlumnoDTO.
     *
     * @param alumnoDTO Objeto AlumnoDTO.
     * @return Entidad Alumno.
     */
    public static Alumno buildAlumnoFromAlumnoDTO(AlumnoDTO alumnoDTO) {
        Alumno alumnoEntity = null;

        if (null != alumnoDTO) {
            alumnoEntity = new Alumno();
            alumnoEntity.setId(alumnoDTO.getId());
            alumnoEntity.setNombre(alumnoDTO.getNombre());
            alumnoEntity.setApellidoPaterno(alumnoDTO.getApellidoPaterno());
            alumnoEntity.setApellidoMaterno(alumnoDTO.getApellidoMaterno());
            alumnoEntity.setEmail(alumnoDTO.getEmail());
            alumnoEntity.setCreateAt(alumnoDTO.getCreateAt());
        }

        return alumnoEntity;
    }

}
