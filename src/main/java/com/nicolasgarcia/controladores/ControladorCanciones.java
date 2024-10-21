package com.nicolasgarcia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nicolasgarcia.modelos.Artista;
import com.nicolasgarcia.modelos.Cancion;
import com.nicolasgarcia.repositorios.RepositorioArtistas;
import com.nicolasgarcia.servicios.ServicioArtistas;
import com.nicolasgarcia.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
    
    @Autowired
    private final ServicioCanciones servicioCanciones;

    @Autowired
    private ServicioArtistas servicioArtistas;

    public ControladorCanciones(ServicioCanciones servicioCanciones) {
        this.servicioCanciones = servicioCanciones;
    }

    // 1. Mostrar todas las canciones
    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
        List<Cancion> canciones = this.servicioCanciones.obtenerTodasLasCanciones();
        modelo.addAttribute("Canciones", canciones);
        return "canciones.jsp";  // Retorna la vista que muestra todas las canciones
    }

    // 2. Mostrar los detalles de una canción específica por ID
    @GetMapping("/canciones/detalles/{idCancion}")
    public String desplegarDetalleCancionId(@PathVariable("idCancion") Long id, Model modelo) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
        if (cancion != null) {
            modelo.addAttribute("cancion", cancion);
            return "detalleCancion.jsp";  // Retorna la vista de detalles de la canción
        } else {
            modelo.addAttribute("error", "Ocurrió un error");
            return "detalleCancion.jsp";  // Maneja el error si la canción no se encuentra
        }
    }

    // 3. Desplegar formulario para agregar una nueva canción
    @GetMapping("/agregar/cancion")
    public String desplegarFormularioAgregarCancion(@ModelAttribute Cancion cancion, Model modelo) {
        List<Artista> artistas = (List<Artista>) this.servicioArtistas.obtenerTodosLosArtistas();
        modelo.addAttribute("artistas", artistas);
        return "agregarCancion.jsp";  // Retorna la vista para agregar una nueva canción
    }

    // 4. Procesar la adición de una nueva canción
    @PostMapping("/agregar/cancion")
    public String procesarAgregarCancion(@Valid @ModelAttribute Cancion cancion, 
                                          BindingResult validaciones,
                                          @RequestParam Long id_artista, Model modelo) {
        if (validaciones.hasErrors()) {
            List<Artista> artistas = this.servicioArtistas.obtenerTodosLosArtistas();
            modelo.addAttribute("artistas", artistas);
            return "agregarCancion.jsp";  // Retorna a la vista si hay errores de validación
        }

        Artista artista = this.servicioArtistas.obtenerArtistaPorId(id_artista);
        cancion.setArtista(artista);
        this.servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";  // Redirige a la lista de canciones después de agregar
    }

    // 5. Mostrar el formulario para editar una canción existente
    @GetMapping("/formulario/editar/cancion/{id}")
    public String formularioEditarCancion(@ModelAttribute Cancion cancion,
                                          @PathVariable Long id,
                                          Model modelo) {
        Cancion editarCancion = servicioCanciones.obtenerCancionPorId(id);
        modelo.addAttribute("cancion", editarCancion);
        return "editarCancion.jsp";  // Retorna la vista para editar la canción
    }

    // 6. Procesar la actualización de una canción existente
    @PutMapping("/actualizar/cancion/{id}")
    public String actualizarCancion(@Valid @ModelAttribute Cancion cancion,
                                     BindingResult validaciones,
                                     @PathVariable Long id) {
        if (validaciones.hasErrors()) {
            return "editarCancion.jsp";  // Retorna a la vista si hay errores de validación
        }
        this.servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";  // Redirige a la lista de canciones después de actualizar
    }

    // 7. Procesar la eliminación de una canción
    @DeleteMapping("/eliminar/cancion/{id}")
    public String procesarEliminarCancion(@PathVariable Long id) {
        this.servicioCanciones.eliminaCancion(id);
        return "redirect:/canciones";  // Redirige a la lista de canciones después de eliminar
    }
}

