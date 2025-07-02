package com.example.demo.Service;
import java.util.List;
import com.example.demo.Entity.Usuario;

public interface UsuarioService {
    public abstract Usuario agregarUsuario(Usuario usuario);
    public abstract Usuario actualizarUsuario(Usuario usuario);
    public abstract void eliminarUsuario(int id);
    public abstract List<Usuario> listarUsuario(String nombre);
    public abstract Usuario obtenerUsuario(int id);
    public abstract void desactivarUsuario(int id);
    public Usuario buscarPorUsername(String username);

}
