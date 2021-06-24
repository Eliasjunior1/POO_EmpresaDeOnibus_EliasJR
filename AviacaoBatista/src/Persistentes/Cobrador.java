package Persistentes;
public class Cobrador extends Funcionarios{
	private String id_cobrador;
	
	public Cobrador(String no, String cp, int idad, String tel, float salar, String cargo){
		super(no,cp, idad, tel,  salar, cargo);
		this.salario = ajuste_salario();
		setId_cobrador(id());
	}
	
	public float ajuste_salario() {
		return (float) (this.salario + 0.600);
	}

	public String getId_cobrador() {
		return id_cobrador;
	}

	public void setId_cobrador(String id_cobrador) {
		this.id_cobrador = id_cobrador;
	}
}
