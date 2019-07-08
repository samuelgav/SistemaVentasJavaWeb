package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;
import dao.ClienteDao;
import model.Cliente;
import oracle.jdbc.internal.OracleTypes;

public class ClienteDaoImpl implements ClienteDao {

	Connection cx;
	
	@Override
	public List<Cliente> ConsultarClientes() {
		CallableStatement cs=null;
		ResultSet rs=null;
		List<Cliente> list=new ArrayList<Cliente>();
		try {
			cx=Conexion.getConnection();
			cs=cx.prepareCall("{call getClienteByName(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			rs=(ResultSet) cs.getObject(1);
			while (rs.next()) {
				Cliente ent=new Cliente();
				ent.setCodCliente(rs.getLong("CODCLIENTE"));
				ent.setNombres(rs.getString("NOMBRES"));
				ent.setApellidos(rs.getString("APELLIDOS"));
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
