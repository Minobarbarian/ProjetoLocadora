package br.ufrn.imd.modelo;

public class Admin extends Usuario{
	private int id_funcionario;
	private String cargo;
	private String supervisor;
	private String departamento;
	
	public int getId_funcionario() {
		return id_funcionario;
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
	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
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
