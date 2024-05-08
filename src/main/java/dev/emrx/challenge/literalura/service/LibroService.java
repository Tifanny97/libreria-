package dev.emrx.challenge.literalura.service;

import dev.emrx.challenge.literalura.model.entity.Idioma;
import dev.emrx.challenge.literalura.model.entity.Libro;
import dev.emrx.challenge.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * LibroService es una clase que proporciona servicios relacionados con la entidad Libro.
 * Utiliza LibroRepository para realizar operaciones de base de datos.
 *
 * @author M3LB1Z
 * @version 1.0
 * @since 2024.1.1
 */
@Service
public class LibroService {

    @Autowired
    private LibroRepository repository;

    /**
     * Este método guarda un libro en la base de datos.
     * Si el libro ya existe, devuelve el libro existente.
     *
     * @param libro El libro a guardar.
     * @return El libro guardado o el libro existente.
     */
    public Libro guardarLibro(Libro libro) {
        Optional<Libro> nuevo = repository.findByTitulo(libro.getTitulo());

        if(!nuevo.isPresent()) {
            return repository.save(libro);
        } else {
            System.out.println("El libro ya existe en la base de datos");
        }

        return nuevo.get();
    }

    /**
     * Este método recupera una lista de todas las entidades Libro.
     *
     * @return Una lista de entidades Libro.
     */
    public List<Libro> obtenerLibros() {
        return repository.findAll();
    }

    /**
     * Este método recupera un Libro por su ID.
     *
     * @param id El ID del libro a buscar.
     * @return El Libro si se encuentra, o null.
     */
    public Libro obtenerLibroPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Este método recupera una lista de entidades Libro que están en un idioma específico.
     *
     * @param idioma El idioma de los libros a buscar.
     * @return Una lista de entidades Libro que están en el idioma especificado.
     */
    public List<Libro> obtenerLibrosPorIdioma(Idioma idioma) {
        return repository.obtenerLibrosPorIdioma(idioma);
    }
}
