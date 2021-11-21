/*
 * Proyecto:        MS - CURSOS
 * A.J. SUX  – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.sux.cursos.ms.app.service.impl;

import com.sux.cursos.ms.app.builder.CursoBuilder;
import com.sux.cursos.ms.app.dao.repository.CursoRepository;
import com.sux.cursos.ms.app.model.dto.CursoDTO;
import com.sux.cursos.ms.app.model.entity.Curso;
import com.sux.cursos.ms.app.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @name CursoServiceImpl
 * @description Implementación de la interface {@link CursoService} que define las operaciones realizar sobre
 * la entidad {@link Curso}.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 20/11/2021 19:43 hrs
 * @version 0.1
 */
@Service("cursoServiceImpl")
public class CursoServiceImpl implements CursoService {

    /**
     * Utilizado para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CursoServiceImpl.class);


    @Autowired
    @Qualifier("cursoRepository")
    private CursoRepository cursoRepository;



    // MÉTODOS

    @Override
    @Transactional(readOnly = true)
    public List<CursoDTO> findAll() {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> findAll()");
        }

        List<CursoDTO> cursoDTOList = CursoBuilder.buildCursoDTOListFromCursoList(cursoRepository.findAll());

        if (LOGGER.isInfoEnabled()) {
            if (cursoDTOList != null) {
                cursoDTOList.forEach( curso -> LOGGER.info("CursoDTO : {}", curso.toString()) );
            }
        }

        return cursoDTOList;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CursoDTO> findById(Long identificador) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> findById( {} )", identificador);
        }

        Optional<Curso> curso = cursoRepository.findById(identificador);

        if (!curso.isPresent()) {
            return Optional.empty();
        }

        CursoDTO cursoDTO = CursoBuilder.buildCursoDTOFromCurso(curso.get());
        Optional<CursoDTO> optionalCursoDTO = Optional.ofNullable(cursoDTO);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Curso DTO : {}", cursoDTO != null ? cursoDTO.toString() : "NULL");
        }

        return optionalCursoDTO;
    }

    @Override
    @Transactional
    public CursoDTO save(CursoDTO cursoDTO) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> save( {} )", cursoDTO.toString());
        }

        Curso curso = CursoBuilder.buildCursoFromCursoDTO(cursoDTO);

        CursoDTO cursoDTOSave = CursoBuilder.buildCursoDTOFromCurso(cursoRepository.save(curso));

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Save Curso DTO : {}", cursoDTOSave.toString());
        }

        return cursoDTOSave;
    }

    @Override
    @Transactional
    public boolean deleteById(Long identificador) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> deleteById( {} )", identificador);
        }

        boolean response = Boolean.FALSE;

        Optional<Curso> curso = cursoRepository.findById(identificador);

        if (curso.isPresent()) {
            cursoRepository.deleteById(identificador);
            response = Boolean.TRUE;
        }

        return response;
    }

}
