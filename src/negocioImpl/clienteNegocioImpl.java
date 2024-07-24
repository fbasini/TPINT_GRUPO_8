package negocioImpl;

import java.util.ArrayList;

import entidad.Cliente;
import entidad.Provincias;
import daoimpl.clienteDaoImpl;
import daoimpl.cuentaDaoImpl;

public class clienteNegocioImpl {
private clienteDaoImpl clientedao; 
	
	public clienteNegocioImpl() {
		
		
		this.clientedao= new clienteDaoImpl();
		
	}
	public ArrayList<Cliente> listarClientes(){
		

		
		return clientedao.listarClientes();
		
	}
	
	public int obtenerIDUsuario ( String usuario) {
		
		return clientedao.obtenerIDClienteDeUsuario(usuario);
	}
	
	public Cliente obtenerClienteActual(int idcliente) {
		
		return clientedao.clienteActual(idcliente);
	}
	
	public ArrayList<Provincias> obtenerProvincias(){
		
		return clientedao.obtenerProvincias();
	}
	
	public boolean comprobarExistenciaDNI(int dni) {
		
		return clientedao.comprobarExistenciaDNI(dni);
	}
	
	public boolean comprobarExistenciaCUIL(int cuil) {
		
		return clientedao.comprobarExistenciaCUIL(cuil);
	}
	
	public int actualizarDatosCliente (Cliente cliente) {
		return clientedao.modificarCliente(cliente);
	}
	
}
