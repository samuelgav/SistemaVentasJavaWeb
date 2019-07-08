package model;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long codusuario;
	private String nombreusuario;
	private String password;
	private Long codvendedor;
	//Variables auxiliares
	private Long codigoVendedor;
	private String nombreCompleto;
	private String dui;
	
	public Usuario() {}
	
	public Usuario(Long codusuario, String nombreusuario, String password, Long codvendedor) {	
		this.codusuario = codusuario;
		this.nombreusuario = nombreusuario;
		this.password = password;
		this.codvendedor = codvendedor;
	}

	public Long getCodusuario() {
		return codusuario;
	}
	public void setCodusuario(Long codusuario) {
		this.codusuario = codusuario;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getCodvendedor() {
		return codvendedor;
	}
	public void setCodvendedor(Long codvendedor) {
		this.codvendedor = codvendedor;
	}
	public Long getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(Long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getDui() {
		return dui;
	}
	public void setDui(String dui) {
		this.dui = dui;
	}
	
	
	
	
}
