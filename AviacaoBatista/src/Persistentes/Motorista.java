package Persistentes;

public class Motorista extends Funcionarios{
	private String cnh;
	private String id_motorista;
	
	
	public Motorista(String no, String cp, int idad, String cn, String tel, float salar, String cargo) {
		super(no,cp, idad, tel, salar, cargo);
		this.cnh = cn;
		
		this.salario = ajuste_salario(salar);
		this.setId_motorista(id());
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public float ajuste_salario(float salar) {
		return (float) (salar + 1.200);
	}

	public String getId_motorista() {
		return id_motorista;
	}

	public void setId_motorista(String id_motorista) {
		this.id_motorista = id_motorista;
	}
	
	public void reajuste_salario() {
		this.salario = (float) (this.salario - 1.200);
	}
	
}
				