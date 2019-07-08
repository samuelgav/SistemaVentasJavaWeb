package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;
import dao.VendedorDao;
import model.Vendedor;
import oracle.jdbc.internal.OracleTypes;

public class VendedorDaoImpl implements VendedorDao {

	Connection cx;
	
	@Override
	public List<Vendedor> listVendedor() {
		CallableStatement cs=null;
		ResultSet rs=null;
		List<Vendedor> list=new ArrayList<Vendedor>();
		try {
			cx=Conexion.getConnection();
			cs=cx.prepareCall("{call getVendedores(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			rs=(ResultSet) cs.getObject(1);
			while (rs.next()) {
				Vendedor ent=new Vendedor();
				ent.setCodVendedor(rs.getLong("CODVENDEDOR"));
				ent.setNombres(rs.getString("NOMBRES"));
				ent.setApellidos(rs.getString("APELLIDOS"));
				ent.setDui(rs.getString("DUI"));
				ent.setCelular(rs.getString("CELULAR"));
				ent.setDireccion(rs.getString("DIRECCION"));
				list.add(ent);
			}
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
		return list;
	}

}
