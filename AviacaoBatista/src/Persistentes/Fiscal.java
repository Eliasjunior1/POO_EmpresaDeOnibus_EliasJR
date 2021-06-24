package Persistentes;

public class Fiscal extends Funcionarios{
	private String id_fiscal;
	
	public Fiscal(String no, String cp, int idad, String tel, float salar, String cargo) {
		super(no, cp, idad, tel, salar, cargo);
		this.salario = ajuste_salario();
		setId_fiscal(id());
	}
	
	public float ajuste_salario() {
		return (float) (this.salario + 1.000);
	}

	public String getId_fiscal() {
		return id_fiscal;
	}

	public void setId_fiscal(String id_fiscal) {
		this.id_fiscal = id_fiscal;
	}
}
