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

import com.nicolasgarcia.modelos.Cancion;
import com.nicolasgarcia.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	@Autowired
	private final ServicioCanciones servicioCanciones;
	
	public ControladorCanciones(ServicioCanciones servicioCanciones) {
		this.servicioCanciones = servicioCanciones;
	}
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo) {
		List<Cancion> canciones = this.servicioCanciones.obtenerTodasLasCanciones();
		modelo.addAttribute("Canciones", canciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalles/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long id, Model modelo) {
		Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
		if(cancion != null) {
			modelo.addAttribute("cancion", cancion);
			return "detalleCancion.jsp";
		}else {
			modelo.addAttribute("error","Ocurrio un error");
			return "detalleCancion.jsp";
		}
		
	}
	
	@GetMapping("/agregar/cancion")
	public String desplegarDetalleCancion(@ModelAttribute Cancion cancion) {
		return "agregarCancion.jsp";
	}
	
	@PostMapping("/agregar/cancion")
	public String procesarAgregarCancion(@Valid @ModelAttribute Cancion cancion, 
								 BindingResult validaciones) {
		if(validaciones.hasErrors()) {
			return "agregarCancion.jsp";
		}
		this.servicioCanciones.agregarCancion(cancion);
		return "redirect:/canciones";
	}
}
