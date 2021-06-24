package Persistentes;

public class Gerente extends Funcionarios{
	
	private String id_gerente;
	private String senha;
	
	public Gerente(String id_gerente,String no, String cp, int idad, String tel, float d, String senha, String cargo) {
		super(no, cp, idad, tel, d, cargo);
		this.id_gerente = id_gerente;
		this.senha = senha;
		this.salario = ajuste_salario();
		
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public float ajuste_salario() {
		
		return this.salario;
	}

	public String getId_gerente() {
		return id_gerente;
	}

	public void setId_gerente(String id_gerente) {
		this.id_gerente = id_gerente;
	}

}
