package dev.emrx.challenge.literalura.service;

import dev.emrx.challenge.literalura.model.entity.Autor;
import dev.emrx.challenge.literalura.model.entity.Idioma;
import dev.emrx.challenge.literalura.model.entity.Libro;
import dev.emrx.challenge.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repository;

    public Libro guardarLibro(Libro libro) {
        Optional<Libro> nuevo = repository.findByTitulo(libro.getTitulo());

        if(!nuevo.isPresent()) {
            return repository.save(libro);
        } else {
            System.out.println("El libro ya existe en la base de datos");
        }

        return nuevo.get();
    }

    public List<Libro> obtenerLibros() {
        return repository.findAll();
    }

    public Libro obtenerLibroPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Libro> obtenerLibrosPorIdioma(Idioma idioma) {
        return repository.obtenerLibrosPorIdioma(idioma);
    }
}
