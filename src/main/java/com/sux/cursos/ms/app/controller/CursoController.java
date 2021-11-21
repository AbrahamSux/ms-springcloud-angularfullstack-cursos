/*
 * Proyecto:        MS - CURSOS
 * A.J. SUX  – Todos los derechos reservados. Para uso exclusivo de Abraham Juárez de la Cruz.
 */
package com.sux.cursos.ms.app.controller;

import com.sux.cursos.ms.app.builder.CursoBuilder;
import com.sux.cursos.ms.app.model.dto.CursoDTO;
import com.sux.cursos.ms.app.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @name CursoController
 * @description Clase que expone el servicio REST para las operaciones relacionadas con los Cursos.
 *
 * @author Abraham Juárez de la Cruz - ajuarezdelacruz93@gmail.com
 * @creationDate 20/11/2021 20:08 hrs
 * @version 0.1
 */
@RestController
@RequestMapping("/cursos/app")
public class CursoController {

    /**
     * Utilizado para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);


    @Autowired
    @Qualifier("cursoServiceImpl")
    private CursoService cursoService;



    // MÉTODOS

    @GetMapping("/cursos")
    public ResponseEntity<?> obtenerListaCursos() {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> obtenerListaCursos()");
        }

        List<CursoDTO> cursoDTOList = cursoService.findAll();

        return ResponseEntity.ok().body(cursoDTOList);
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<?> obtenerCurso(@PathVariable(name = "id") Long identificador) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> obtenerCurso( {} )", identificador);
        }

        Optional<CursoDTO> cursoDTO = cursoService.findById(identificador);

        if (!cursoDTO.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(cursoDTO);
    }

    @PostMapping("/curso")
    public ResponseEntity<?> guardarCurso(@RequestBody CursoDTO curso) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> guardarCurso( {} )", curso.toString());
        }

        CursoDTO cursoDTO = cursoService.save(curso);

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoDTO);
    }

    @PutMapping("/curso/{id}")
    public ResponseEntity<?> editarCurso(@RequestBody CursoDTO curso, @PathVariable(name = "id") Long identificador) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> editarCurso( {}, {} )", curso.toString(), identificador);
        }

        Optional<CursoDTO> optional = cursoService.findById(identificador);

        if (optional.isPresent()) {
            CursoDTO cursoDTO = CursoBuilder.buildCursoDTOUpdatedForCursoOptional(optional, curso);

            if (cursoDTO != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(cursoDTO));
            }
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable(name = "id") Long identificador) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> eliminarCurso( {} )", identificador);
        }

        boolean response = cursoService.deleteById(identificador);

        return ResponseEntity.ok(response);
    }

}
