package dev.emrx.challenge.literalura.service;

import dev.emrx.challenge.literalura.model.entity.Autor;
import dev.emrx.challenge.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public List<Autor> obtenerAutores() {
        return repository.findAll();
    }

    public List<Autor> obtenerAutoresVivosPorAnio(int anio) {
        return repository.obtenerAutoresVivosPorAnio(anio);
    }
}
