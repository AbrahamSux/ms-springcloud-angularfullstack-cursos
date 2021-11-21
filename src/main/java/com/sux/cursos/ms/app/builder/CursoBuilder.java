/*
 * Proyecto:        MS - CURSOS
 * A.J. SUX  – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.sux.cursos.ms.app.builder;

import com.sux.cursos.ms.app.model.dto.AlumnoDTO;
import com.sux.cursos.ms.app.model.dto.CursoDTO;
import com.sux.cursos.ms.app.model.entity.Curso;

import java.util.ArrayList;
import java.util.List;

/**
 * @name CursoBuilder
 * @description Builder que se encaraga de fabricar objetos Entity a partir de objetos DTO y viceversa.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 22/11/2021 16:07 hrs
 * @version 0.2
 */
public class CursoBuilder {



    public CursoBuilder() {
    }


    /**
     * Método que construye una lista de objetos de tipo CursoDTO a partir de una lista de objetos de tipo Curso.
     *
     * @param cursoList Lista de Cursos de tipo Entity.
     * @return Lista de Cursos de tipo DTO.
     */
    public static List<CursoDTO> buildCursoDTOListFromCursoList(List<Curso> cursoList) {
        List<CursoDTO> cursoDTOList = null;

        if (cursoList != null) {
            cursoDTOList = new ArrayList<>();
            for (Curso curso : cursoList) {
                cursoDTOList.add(buildCursoDTOFromCurso(curso));
            }
        }

        return cursoDTOList;
    }

    /**
     * Método que convierte de un entity de tipo Curso a un objeto de tipo CursoDTO.
     *
     * @param curso Entidad Curso.
     * @return Objeto CursoDTO.
     */
    public static CursoDTO buildCursoDTOFromCurso(Curso curso) {
        CursoDTO cursoDTO = null;

        if (curso != null) {
            cursoDTO = new CursoDTO();
            cursoDTO.setId(curso.getId());
            cursoDTO.setNombre(curso.getNombre());
            cursoDTO.setDescripcion(curso.getDescripcion());
            cursoDTO.setAlumnos( AlumnoBuilder.buildAlumnoDTOListFromAlumnoList(curso.getAlumnos()) );
            cursoDTO.setCreateAt(curso.getCreateAt());
        }

        return cursoDTO;
    }

    /**
     * Método que construye un entity Curso a partir de un objeto de tipo CursoDTO.
     *
     * @param cursoDTO Objeto CursoDTO.
     * @return Entidad Curso.
     */
    public static Curso buildCursoFromCursoDTO(CursoDTO cursoDTO) {
        Curso curso = null;

        if (cursoDTO != null) {
            curso = new Curso();
            curso.setId(cursoDTO.getId());
            curso.setNombre(cursoDTO.getNombre());
            curso.setDescripcion(cursoDTO.getDescripcion());
            curso.setAlumnos( AlumnoBuilder.buildAlumnoListFromAlumnoDTOList(cursoDTO.getAlumnos()) );
            curso.setCreateAt( cursoDTO.getId() != null ? cursoDTO.getCreateAt() : null );
        }

        return curso;
    }

    /**
     * Método auxiliar utilizado para actualizar un CursoDTO a partir de un CursoDTO Origen (persistido en base de datos)
     * y otro CursoDTO Nuevo (con los datos a actualizar).
     *
     * @param originCursoDTO Objeto de tipo CursoDTO persistido en la base de datos.
     * @param newCursoDTO Objeto de tipo CursoDTO con los datos a actualizar.
     * @return Objeto CursoDTO con los datos actualizados.
     */
    public static CursoDTO buildCursoDTOUpdated(CursoDTO originCursoDTO, CursoDTO newCursoDTO) {

        if (originCursoDTO != null && newCursoDTO != null) {
            // Datos que se actualizarán
            originCursoDTO.setNombre(newCursoDTO.getNombre());
            originCursoDTO.setDescripcion(newCursoDTO.getDescripcion());
        }

        return originCursoDTO;
    }

    /**
     * Método auxiliar utilizado para agregar alumnos a un curso.
     *
     * @param cursoDTO Objeto de tipo CursoDTO al que se le agregarán los alumnos.
     * @param alumnoDTOList Lista de Alumnos a agregar.
     * @return Objeto de tipo CursoDTO con los alumnos agregados.
     */
    public static CursoDTO addStudentsToTheCourse(CursoDTO cursoDTO, List<AlumnoDTO> alumnoDTOList) {

        if (cursoDTO != null && alumnoDTOList != null) {
            alumnoDTOList.forEach(cursoDTO::addAlumno);
        }

        return cursoDTO;
    }

}
