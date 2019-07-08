package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;
import dao.UsuarioDao;

import model.Usuario;
import oracle.jdbc.internal.OracleTypes;

public class UsuarioDaoImpl implements UsuarioDao {

	Connection cx;
	
	@Override
	public Usuario validarUsuario(String usuario,String password) {
		CallableStatement cs=null;
		ResultSet rs=null;
		List<Usuario> list=new ArrayList<Usuario>();
		Usuario user=null;
		try {
			cx=Conexion.getConnection();
			cs=cx.prepareCall("{call validarUsuario(?,?,?)}");
			cs.setString(1, usuario);
			cs.setString(2, password);
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.execute();
			rs=(ResultSet) cs.getObject(3);
			while (rs.next()) {
				Usuario ent=new Usuario();
				ent.setCodusuario(rs.getLong("codusuario"));
				ent.setNombreusuario(rs.getString("nombreusuario"));
				ent.setPassword(rs.getString("password"));
				ent.setCodvendedor(rs.getLong("codvendedor"));
				ent.setCodigoVendedor(rs.getLong("codigoVendedor"));
				ent.setNombreCompleto(rs.getString("nombreCompleto"));
				ent.setDui(rs.getString("dui"));
				list.add(ent);
			}
			if(list == null || list.size() ==0) return null;
			user = list.get(0);			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(cs !=null) cs.close();
				if(cx !=null) cx.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return user;
	}

}
