package com.example.demo.Controller;

import com.example.demo.Entity.Usuario;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioservice")
	private UsuarioService usuarioservice;


	@GetMapping("")
	public String redireccionar() {
		return "redirect:/usuario/lista";
	}

	@GetMapping("/lista")
	public ModelAndView listar(@RequestParam(required = false) String nombreBuscar) {
		ModelAndView mv = new ModelAndView("usuarios/ListaUsuario"); // Nombre del HTML
		mv.addObject("listaU", usuarioservice.listarUsuario(nombreBuscar)); // Enviar lista al HTML
		return mv;
	}

	@GetMapping("/ver/{id}")
	public String ver(@PathVariable("id") int id, Model model) {
		Usuario usuario = usuarioservice.obtenerUsuario(id);
		model.addAttribute("usuario", usuario);
		return "usuarios/VerUsuario"; // Nombre del HTML
	}

	@GetMapping("/gcrear")
	public String crear(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "usuarios/CrearUsuario"; // Nombre del HTML
	}

	@PostMapping("/pcrear")
	public String crear(@ModelAttribute("usuario") Usuario usuario) {
		try {
			// Generar username
			String nombreCompleto = usuario.getNombre().trim().replaceAll(" +", " ");
			String primerNombre = nombreCompleto.split(" ")[0];
			String username = usuario.getApPaterno() + "_" + primerNombre;
			usuario.setUsername(username.toLowerCase());
			usuarioservice.agregarUsuario(usuario);
			return "redirect:/usuario/lista";
		} catch (Exception e) {
			System.out.println("Error al crear usuario: " + e.getMessage());
			return "usuarios/CrearUsuario";
		}
	}
	@GetMapping("/geditar/{id}")
	public String editarForm(@PathVariable("id") int id, Model model) {
		Usuario usuario = usuarioservice.obtenerUsuario(id);
		if (usuario == null) {
			return "redirect:/usuario/lista";
		}
		model.addAttribute("usuario", usuario);
		return "usuarios/EditarUsuario";
	}


	@PostMapping("/peditar/{id}")
	public String editar(@ModelAttribute("usuario") Usuario usuario, @PathVariable("id") int id) {
		try {
			Usuario usu = usuarioservice.obtenerUsuario(id);

			usu.setDni(usuario.getDni());
			usu.setNombre(usuario.getNombre());
			usu.setApPaterno(usuario.getApPaterno());
			usu.setApMaterno(usuario.getApMaterno());

			String nombreCompleto = usuario.getNombre().trim().replaceAll(" +", " ");
			String primerNombre = nombreCompleto.split(" ")[0];
			String usernameGenerado = usuario.getApPaterno() + "_" + primerNombre;
			usu.setUsername(usernameGenerado.toLowerCase());

			usu.setPassword(usuario.getPassword());
			usu.setActivo(usuario.isActivo());

			usuarioservice.actualizarUsuario(usu);
			return "redirect:/usuario/lista";
		} catch (Exception e) {
			System.out.println("Error al editar usuario: " + e.getMessage());
			return "redirect:/usuario/lista";
		}
	}

	@PostMapping("/desactivar/{id}")
	public String desactivar(@PathVariable("id") int id) {
		usuarioservice.desactivarUsuario(id);
		return "redirect:/usuario/lista";
	}

}
