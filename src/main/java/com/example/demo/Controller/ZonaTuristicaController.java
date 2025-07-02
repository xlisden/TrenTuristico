package com.example.demo.Controller;

import com.example.demo.Entity.Usuario;
import com.example.demo.Entity.ZonaTuristica;
import com.example.demo.Service.ActividadService;
import com.example.demo.Service.IZonaTuristicaService;
import com.example.demo.Service.ServiceImpl.EstacionService;
import com.example.demo.Service.TipoLugarService;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/zona")
public class ZonaTuristicaController {

	@Autowired
	private IZonaTuristicaService zonaService;
	@Autowired
	private EstacionService estacionService;
	@Autowired
	private ActividadService actividadService;
	@Autowired
	private TipoLugarService tipoLugarService;
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping({"", "/", "/lista"})
	public String listarZonas(Model model) {
		try {
			model.addAttribute("zonas", zonaService.listarZonas());
		} catch (Exception e) {
			model.addAttribute("error", "Error al cargar las zonas: " + e.getMessage());
		}
		return "ZonaTuristica/ListaZona";
	}

	@GetMapping("/crear")
	public String mostrarFormularioCrear(Model model) {
		try {
			model.addAttribute("zona", new ZonaTuristica());
			model.addAttribute("estaciones", estacionService.listar());
			model.addAttribute("actividades", actividadService.listar());
			model.addAttribute("tiposLugar", tipoLugarService.findAllTipoLugar());
		} catch (Exception e) {
			model.addAttribute("error", "Error al cargar el formulario: " + e.getMessage());
		}
		return "ZonaTuristica/CrearZona";
	}

	@PostMapping("/pcrear")
	public String guardarZona(@ModelAttribute ZonaTuristica zona, RedirectAttributes redirectAttributes) {
		try {
			zona.setActivo(true);

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();

			Usuario usuario = usuarioService.buscarPorUsername(username);
			if (usuario == null) throw new RuntimeException("Usuario no encontrado");

			zona.setCreadoPor(usuario);

			zonaService.guardarZona(zona);
			redirectAttributes.addFlashAttribute("mensaje", "Zona turística creada exitosamente");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Error al guardar la zona: " + e.getMessage());
		}
		return "redirect:/zona/lista";
	}

	@GetMapping("/ver/{id}")
	public String verZona(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
		try {
			ZonaTuristica zona = zonaService.obtenerZonaPorId(id);
			if (zona == null) {
				redirectAttributes.addFlashAttribute("error", "Zona no encontrada");
				return "redirect:/zona/lista";
			}
			model.addAttribute("zona", zona);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Error al cargar la zona: " + e.getMessage());
			return "redirect:/zona/lista";
		}
		return "ZonaTuristica/VerZona";
	}

	@GetMapping("/editar/{id}")
	public String editarZona(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
		try {
			ZonaTuristica zona = zonaService.obtenerZonaPorId(id);
			if (zona == null) {
				redirectAttributes.addFlashAttribute("error", "Zona no encontrada");
				return "redirect:/zona/lista";
			}
			model.addAttribute("zona", zona);
			model.addAttribute("estaciones", estacionService.listar());
			model.addAttribute("actividades", actividadService.listar());
			model.addAttribute("tiposLugar", tipoLugarService.findAllTipoLugar());
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Error al cargar el formulario: " + e.getMessage());
			return "redirect:/zona/lista";
		}
		return "ZonaTuristica/EditarZona";
	}

	@PostMapping("/editar/{id}")
	public String actualizarZona(@ModelAttribute ZonaTuristica zona, @PathVariable int id, RedirectAttributes redirectAttributes) {
		try {
			ZonaTuristica existente = zonaService.obtenerZonaPorId(id);
			if (existente == null) {
				redirectAttributes.addFlashAttribute("error", "Zona no encontrada");
				return "redirect:/zona/lista";
			}

			zona.setId(id);
			zona.setCreadoPor(existente.getCreadoPor()); // se mantiene el creador original
			zonaService.actualizarZona(zona);

			redirectAttributes.addFlashAttribute("mensaje", "Zona turística actualizada exitosamente");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Error al actualizar la zona: " + e.getMessage());
		}
		return "redirect:/zona/lista";
	}

	@PostMapping("/desactivar/{id}")
	public String desactivarZona(@PathVariable int id, RedirectAttributes redirectAttributes) {
		try {
			zonaService.desactivarZona(id);
			redirectAttributes.addFlashAttribute("mensaje", "Zona turística desactivada exitosamente");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Error al desactivar la zona: " + e.getMessage());
		}
		return "redirect:/zona/lista";
	}
}
