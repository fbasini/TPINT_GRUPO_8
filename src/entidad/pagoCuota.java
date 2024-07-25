package entidad;


import java.math.BigDecimal;
import java.time.LocalDate;

public class pagoCuota {
	private int idCuota;
	private int idPrestamo;
	private int idCuenta;
	private int idCliente;
	private BigDecimal montoAPagar;
	private int cuotas;
	private LocalDate fechaPago;
	private char pagado;
	
	public pagoCuota() {}
	
	
	
	public pagoCuota(int idCuota, int idPrestamo, int idCuenta, int idCliente, BigDecimal montoAPagar, int cuotas,
			LocalDate fechaPago, char pagado) {
		super();
		this.idCuota = idCuota;
		this.idPrestamo = idPrestamo;
		this.idCuenta = idCuenta;
		this.idCliente = idCliente;
		this.montoAPagar = montoAPagar;
		this.cuotas = cuotas;
		this.fechaPago = fechaPago;
		this.pagado = pagado;
	}

	public int getIdCuota() {
		return idCuota;
	}
	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}
	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public BigDecimal getMontoAPagar() {
		return montoAPagar;
	}
	public void setMontoAPagar(BigDecimal montoAPagar) {
		this.montoAPagar = montoAPagar;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	public char getPagado() {
		return pagado;
	}
	public void setPagado(char pagado) {
		this.pagado = pagado;
	}
	
	
	
}
