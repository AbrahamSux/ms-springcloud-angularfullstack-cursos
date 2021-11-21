/*
 * Proyecto:        MS - CURSOS
 * A.J. SUX  – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.sux.cursos.ms.app.dao.repository;

import com.sux.cursos.ms.app.model.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @name CursoRepository
 * @description Repositorio que realiza las consultas sobre la entidad {@link Curso}.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 20/11/2021 19:31 hrs
 * @version 0.1
 */
@Repository("cursoRepository")
public interface CursoRepository extends JpaRepository<Curso, Long> {



}
