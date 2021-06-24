package Persistentes;

import java.util.Random;

public abstract class Funcionarios {
	
	protected String nome;
	protected String cpf;
	protected int idade;
	protected String telefone;
	protected float salario;
	protected String cargo;
	
	
	public Funcionarios(String no, String cp, int idad, String tel, float sa, String cargo){
		this.nome = no;
		this.cpf = cp;
		this.idade = idad;
		this.telefone = tel;
		this.salario = sa;
		this.cargo = cargo;
		
		
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public float ajuste_salario() {
		
		return this.salario;
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String id() {
		int i;
		char[] letras = "ABCDEFGHIJKLMNOPQRSTUVXYZ".toCharArray();
		
		Random rand = new Random();
		StringBuffer placa = new StringBuffer();
		
		for(i = 0; i < 3; i++) {
			int ch = rand.nextInt (letras.length);
			placa.append(letras[ch]);
		}
		placa.append("-");
		
		for(i = 0; i < 4; i++) {
			int ch = rand.nextInt (9) + 1;
			placa.append(ch);
		}
		
		return placa.toString();
		
	}
	
}

