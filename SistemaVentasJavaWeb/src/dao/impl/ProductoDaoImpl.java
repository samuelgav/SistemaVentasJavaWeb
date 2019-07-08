package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;
import dao.ProductoDao;
import model.Producto;
import oracle.jdbc.internal.OracleTypes;

public class ProductoDaoImpl implements ProductoDao {

	Connection cx;
	
	@Override
	public List<Producto> listProduct() {
		CallableStatement cs=null;
		ResultSet rs=null;
		List<Producto> list=new ArrayList<Producto>();
		try {
			cx=Conexion.getConnection();
			cs=cx.prepareCall("{call getProductos(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			rs=(ResultSet) cs.getObject(1);
			while (rs.next()) {
				Producto ent=new Producto();
				ent.setCodProducto(rs.getLong("CODPRODUCTO"));
				ent.setNombreProducto(rs.getString("NOMBREPRODUCTO"));
				ent.setPrecioVenta(rs.getFloat("PRECIOVENTA"));
				ent.setStockMinimo(rs.getInt("STOCKMINIMO"));
				ent.setStockActual(rs.getInt("STOCKACTUAL"));
				ent.setCodBarra(rs.getString("CODBARRA"));
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

	@Override
	public boolean manageProduct(Producto producto,Integer modo) {
		CallableStatement cs=null;
		try {
			cx=Conexion.getConnection();
			cs=cx.prepareCall("{call spinsertProduct(?,?,?,?,?,?,?)}");
			cs.setInt(1,modo);
			cs.setLong(2, producto.getCodProducto());
			cs.setString(3, producto.getNombreProducto());
			cs.setFloat(4, producto.getPrecioVenta());
			cs.setInt(5,producto.getStockMinimo());
			cs.setInt(6, producto.getStockActual());
			cs.setString(7, producto.getCodBarra());
			cs.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Producto getProductById(Long id) {
		CallableStatement cs=null;
		ResultSet rs=null;
		Producto ent=null;
		try {
			cx=Conexion.getConnection();
			cs=cx.prepareCall("{call getProductobyId(?,?)}");
			cs.setLong(1, id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			rs=(ResultSet) cs.getObject(2);
			while (rs.next()) {
				ent=new Producto();
				ent.setCodProducto(rs.getLong("CODPRODUCTO"));
				ent.setNombreProducto(rs.getString("NOMBREPRODUCTO"));
				ent.setPrecioVenta(rs.getFloat("PRECIOVENTA"));
				ent.setStockMinimo(rs.getInt("STOCKMINIMO"));
				ent.setStockActual(rs.getInt("STOCKACTUAL"));
				ent.setCodBarra(rs.getString("CODBARRA"));				
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
		return ent;
	}

	@Override
	public boolean deleteProduct(Long id) {
		CallableStatement cs=null;
		try {
			cx=Conexion.getConnection();
			cs=cx.prepareCall("{call deleteProducto(?)}");
			cs.setLong(1,id);			
			cs.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Producto getProductByCodBarra(String codBarra) {
		CallableStatement cs=null;
		ResultSet rs=null;
		Producto ent=null;
		try {
			cx=Conexion.getConnection();
			cs=cx.prepareCall("{call getProductByCodBarra(?,?)}");
			cs.setString(1, codBarra);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			rs=(ResultSet) cs.getObject(2);
			while (rs.next()) {
				ent=new Producto();
				ent.setCodProducto(rs.getLong("CODPRODUCTO"));
				ent.setNombreProducto(rs.getString("NOMBREPRODUCTO"));
				ent.setPrecioVenta(rs.getFloat("PRECIOVENTA"));
				ent.setStockMinimo(rs.getInt("STOCKMINIMO"));
				ent.setStockActual(rs.getInt("STOCKACTUAL"));
				ent.setCodBarra(rs.getString("CODBARRA"));				
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
		return ent;
	}

}
