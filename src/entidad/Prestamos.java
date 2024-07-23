package entidad;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Prestamos {

	private int idPrestamo;
	private int idcuenta;
	private int idcliente;
	private LocalDate fechaPrestamo;
	private double importeAPagar;
	private double importeSolicitado;
	private int PlazoEnCuotas;
	private double montoPorCuota;
	private char autorizado;
	
	public Prestamos() {}

	
	public Prestamos(int idPrestamo, int idcuenta, int idcliente, LocalDate fechaPrestamo, double importeAPagar,
			double importeSolicitado, int plazoEnCuotas, double montoPorCuota, char autorizado) {
		super();
		this.idPrestamo = idPrestamo;
		this.idcuenta = idcuenta;
		this.idcliente = idcliente;
		this.fechaPrestamo = fechaPrestamo;
		this.importeAPagar = importeAPagar;
		this.importeSolicitado = importeSolicitado;
		PlazoEnCuotas = plazoEnCuotas;
		this.montoPorCuota = montoPorCuota;
		this.autorizado = autorizado;
	}


	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public int getIdcuenta() {
		return idcuenta;
	}

	public void setIdcuenta(int idcuenta) {
		this.idcuenta = idcuenta;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	

	public double getImporteAPagar() {
		return importeAPagar;
	}


	public void setImporteAPagar(double importeAPagar) {
		this.importeAPagar = importeAPagar;
	}


	public double getImporteSolicitado() {
		return importeSolicitado;
	}


	public void setImporteSolicitado(double importeSolicitado) {
		this.importeSolicitado = importeSolicitado;
	}


	public double getMontoPorCuota() {
		return montoPorCuota;
	}


	public void setMontoPorCuota(double montoPorCuota) {
		this.montoPorCuota = montoPorCuota;
	}


	public int getPlazoEnCuotas() {
		return PlazoEnCuotas;
	}

	public void setPlazoEnCuotas(int plazoEnCuotas) {
		PlazoEnCuotas = plazoEnCuotas;
	}

	

	public char getAutorizado() {
		return autorizado;
	}

	public void setAutorizado(char autorizado) {
		this.autorizado = autorizado;
	}

	@Override
	public String toString() {
		return "Prestamos [idPrestamo=" + idPrestamo + ", idcuenta=" + idcuenta + ", idcliente=" + idcliente
				+ ", fechaPrestamo=" + fechaPrestamo + ", importeAPagar=" + importeAPagar + ", importeSolicitado="
				+ importeSolicitado + ", PlazoEnCuotas=" + PlazoEnCuotas + ", montoPorCuota=" + montoPorCuota
				+ ", autorizado=" + autorizado + "]";
	}
	
	
}
