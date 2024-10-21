package com.nicolasgarcia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasgarcia.modelos.Artista;
import com.nicolasgarcia.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private final RepositorioArtistas repositorioArtistas;

    public ServicioArtistas(RepositorioArtistas repositorioArtistas) {
        this.repositorioArtistas = repositorioArtistas;
    }

    // Método para obtener todos los artistas
    public List<Artista> obtenerTodosLosArtistas() {
        return repositorioArtistas.findAll();
    }

    // Método para obtener un artista por su ID
    public Artista obtenerArtistaPorId(Long id) {
        return this.repositorioArtistas.findById(id).orElse(null);
    }

    // Método para agregar un nuevo artista
    public Artista agregarArtista(Artista artista) {
        return repositorioArtistas.save(artista);
    }
}
