/*
 * Proyecto:        MS - CURSOS
 * A.J. SUX  – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.sux.cursos.ms.app.builder;

import com.sux.cursos.ms.app.model.dto.CursoDTO;
import com.sux.cursos.ms.app.model.entity.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @name CursoBuilder
 * @description Builder que se encaraga de fabricar objetos Entity a partir de objetos DTO y viceversa.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 22/11/2021 16:07 hrs
 * @version 0.1
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
            curso.setCreateAt( cursoDTO.getId() != null ? cursoDTO.getCreateAt() : null );
        }

        return curso;
    }

    /**
     * Método que construye un CursoDTO a partir de un objeto de tipo Optional<CursoDTO> y otro CursoDTO.
     *
     * @param optional Optional de tipo CursoDTO.
     * @param cursoDTO Objeto de tipo CursoDTO.
     * @return Objeto CursoDTO
     */
    public static CursoDTO buildCursoDTOUpdatedForCursoOptional(Optional<CursoDTO> optional, CursoDTO cursoDTO) {
        CursoDTO cursoDTOUpdated = null;

        if (optional.isPresent() && cursoDTO != null) {
            cursoDTOUpdated = new CursoDTO();
            cursoDTOUpdated.setId(optional.get().getId());
            cursoDTOUpdated.setNombre(cursoDTO.getNombre());
            cursoDTOUpdated.setDescripcion(cursoDTO.getDescripcion());
            cursoDTOUpdated.setCreateAt(optional.get().getCreateAt());
        }

        return cursoDTOUpdated;
    }

}
