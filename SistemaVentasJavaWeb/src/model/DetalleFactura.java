package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleFactura implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long codDetalle;
	private Long codFactura;
	private Long codProducto;
	private String codBarra;
	private String nombreProducto;
	private Integer cantidad;
	private float precioVenta;
	private float total;
	
	public DetalleFactura() {} 
	
	
	public DetalleFactura(Long codDetalle, Long codFactura, Long codProducto, String codBarra, String nombreProducto,
			Integer cantidad, float precioVenta, float total) {
		this.codDetalle = codDetalle;
		this.codFactura = codFactura;
		this.codProducto = codProducto;
		this.codBarra = codBarra;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.total = total;
	}
	
	public Long getCodDetalle() {
		return codDetalle;
	}
	public void setCodDetalle(Long codDetalle) {
		this.codDetalle = codDetalle;
	}
	public Long getCodFactura() {
		return codFactura;
	}
	public void setCodFactura(Long codFactura) {
		this.codFactura = codFactura;
	}
	public Long getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(Long codProducto) {
		this.codProducto = codProducto;
	}
	public String getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
