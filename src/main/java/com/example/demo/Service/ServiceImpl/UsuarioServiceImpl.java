package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Actividad;
import com.example.demo.Entity.Usuario;
import com.example.demo.Repository.ActividadRepository;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.Service.ActividadService;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("usuarioservice")
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	@Qualifier("usurepository")
	private UsuarioRepository usurepository;
	@Override
	public List<Usuario> listaSimple() {
		return usurepository.findAll();
	}


	@Override
	public Usuario agregarUsuario(Usuario usuario) {
		return usurepository.save(usuario);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return usurepository.save(usuario);
	}

	@Override
	public void eliminarUsuario(int id) {
         usurepository.deleteById(id);
	}

	@Override
	public List<Usuario> listarUsuario(String nombre) {
		if (nombre == null || nombre.isBlank())
			return usurepository.findAll();
		return usurepository.findByNombreContainingIgnoreCase(nombre);
	}


	@Override
	public Usuario obtenerUsuario(int id) {
		return usurepository.obtenerUsuario(id);
	}

	@Override
	public void desactivarUsuario(int id) {
		Usuario usuario = usurepository.obtenerUsuario(id);
		if (usuario != null) {
			usuario.setActivo(false);
			usurepository.save(usuario);
		}
	}
	@Override
	public Usuario buscarPorUsername(String username) {
		Optional<Usuario> opt = usurepository.findByUsername(username);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new RuntimeException("Usuario no encontrado con username: " + username);
		}
	}

}
	

