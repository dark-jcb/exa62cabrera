/**
 * 
 */
package ec.edu.ups.ppw.negocio;

import ec.edu.ups.ppw.datos.MotocicletaDAO;
import ec.edu.ups.ppw.modelo.Motocicleta;
import jakarta.inject.Inject;

/**
 * @author Darwin Cabrera
 */
public class GestionMotocicleta {
	@Inject
	private MotocicletaDAO daoMotocicleta;

	public void guardarMotocicleta(Motocicleta motocicleta) throws Exception {
		if (!this.validarPlaca(motocicleta.getPlaca()))
			throw new Exception("Placa incorrecta, verifique correctamente los datos");
		if (daoMotocicleta.leerMotocicleta(motocicleta.getPlaca()) == null) {
			try {
				daoMotocicleta.insertarMotocicleta(motocicleta);

			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Error al intentar insertar: " + e.getMessage());
			}
		} else {
			try {
				daoMotocicleta.actualizarMotocicleta(motocicleta);

			} catch (Exception e) {
				throw new Exception("Error al intentar actualizar: " + e.getMessage());
			}

		}
	}

	private boolean validarPlaca(String placa) {
		boolean validacion = true;
		if (placa.length() != 6) {
			validacion = false;

		}
		if (!placa.substring(0, 2).matches("[A-Z]*")) {
			validacion = false;
		}
		if (!placa.substring(2).matches("[0-9]*")) {
			validacion = false;
		}

		return validacion;

	}

	public void guardarMotocicleta(String placaMoto, String marcaMoto, String colorMoto, double precioMoto) {
	}

}
