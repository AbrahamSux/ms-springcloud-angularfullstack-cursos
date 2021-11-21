/*
 * Proyecto:        MS - CURSOS
 * A.J. SUX  – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.sux.cursos.ms.app.service;

import com.sux.cursos.ms.app.model.dto.CursoDTO;
import com.sux.cursos.ms.app.model.entity.Curso;

import java.util.List;
import java.util.Optional;

/**
 * @name CursoService
 * @description Interfaz que contiene las operaciones a realizar sobre la entidad {@link Curso}.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 20/11/2021 19:38 hrs
 * @version 0.1
 */
public interface CursoService {

    /**
     * Método encargado de obtener una lista de objetos de tipo CursoDTO.
     *
     * @return Lista de objetos de tipo CursoDTO.
     */
    List<CursoDTO> findAll();

    /**
     * Metodo que regresa un objeto de tipo CursoDTO en base a un identificador recibido.
     *
     * @param identificador Identificador del Curso.
     * @return Objeto de tipo CursoDTO.
     */
    Optional<CursoDTO> findById(Long identificador);

    /**
     * Método encargado de mandar a guardar al objeto de tipo CursoDTO recibido.
     *
     * @param cursoDTO Objeto Curso.
     * @return Objeto de tipo CursoDTO.
     */
    CursoDTO save(CursoDTO cursoDTO);

    /**
     * Método encargado de mandar a eliminar al Curso correspondiente al identificador recibido.
     *
     * @param identificador Identificador del Curso.
     * @return TRUE si el curso se elimino correctamente, FALSE en caso contrario.
     */
    boolean deleteById(Long identificador);

}
