package entidad;

public class Estadistica {

	private int idResultado;
	private double montoResultado;
	
	public Estadistica(){}

	public Estadistica(int idResultado, double montoResultado) {
		super();
		this.idResultado = idResultado;
		this.montoResultado = montoResultado;
	}

	public int getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}

	public double getMontoResultado() {
		return montoResultado;
	}

	public void setMontoResultado(double montoResultado) {
		this.montoResultado = montoResultado;
	}

	@Override
	public String toString() {
		return "Estadistica [idResultado=" + idResultado + ", montoResultado=" + montoResultado + "]";
	}
	
	
	
	
}
