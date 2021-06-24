package Persistentes;

public class Rotas{
	private int id_rota;
	private String origem;
	private String destino;
	private String onibus;
	
	
	public Rotas(String origem, String destino, int id_rota){
		this.origem = origem;
		this.destino = destino;
		this.id_rota = id_rota;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getOnibus() {
		return onibus;
	}


	public void setOnibus(String onibus) {
		this.onibus = onibus;
	}


	public int getId_rota() {
		return id_rota;
	}


	public void setId_rota(int id_rota) {
		this.id_rota = id_rota;
	}

}
