package dao;

import model.Usuario;

public interface UsuarioDao {

	Usuario validarUsuario(String usuario,String password);
}
