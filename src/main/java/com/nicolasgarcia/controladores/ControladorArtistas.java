package com.nicolasgarcia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nicolasgarcia.modelos.Artista;
import com.nicolasgarcia.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
    
    @Autowired
    private ServicioArtistas servicioArtistas;

    public ControladorArtistas(ServicioArtistas servicioArtistas) {
        this.servicioArtistas = servicioArtistas;
    }

    // Mostrar todos los artistas
    @GetMapping("/artistas")
    public String mostrarArtistas(Model modelo) {
        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        modelo.addAttribute("artistas", artistas);
        return "artistas.jsp";
    }

    // Desplegar formulario para registrar un nuevo artista
    @GetMapping("/registro")
    public String desplegarRegistro(@ModelAttribute("nuevoArtista") Artista nuevoArtista) {
        return "agregarArtista.jsp";
    }

    // Procesar la adición de un nuevo artista
    @PostMapping("/agregar/artista")
    public String agregarArtista(@Valid @ModelAttribute("nuevoArtista") Artista nuevoArtista,
                                 BindingResult validaciones) {
        if (validaciones.hasErrors()) {
            return "agregarArtista.jsp";
        }
        servicioArtistas.agregarArtista(nuevoArtista); 
        return "redirect:/canciones";
    }

    // Desplegar detalles de un artista específico
    @GetMapping("/artistas/detalles/{id}")
    public String desplegarDetalleArtista(@PathVariable("id") Long id, Model modelo) {
        Artista artista = servicioArtistas.obtenerArtistaPorId(id);
        if (artista != null) {
            modelo.addAttribute("artista", artista); 
            return "detalleArtista.jsp";
        } else {
            modelo.addAttribute("error", "Ocurrió un error, el artista no fue encontrado");
            return "error.jsp";
        }
    }
}

