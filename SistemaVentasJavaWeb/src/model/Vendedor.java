package model;

import java.io.Serializable;

public class Vendedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long codVendedor;
	private String nombres;
	private String apellidos;
	private String dui;
	private String celular;
	private String direccion;
	
	public Vendedor() {}

	public Long getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(Long codVendedor) {
		this.codVendedor = codVendedor;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
