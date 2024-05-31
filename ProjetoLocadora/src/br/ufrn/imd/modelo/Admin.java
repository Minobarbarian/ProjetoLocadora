package br.ufrn.imd.modelo;

public class Admin extends Usuario{
	private int id_admin;
	private String cargo;
	private String supervisor;
	private String departamento;
	
	public int getId_admin() {
		return id_admin;
	}
	public String getCargo() {
		return cargo;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
	
}
