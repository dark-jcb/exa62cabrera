package ec.edu.ups.ppw.servicios;

import java.util.List;

import ec.edu.ups.ppw.datos.MotocicletaDAO;
import ec.edu.ups.ppw.modelo.Motocicleta;
import ec.edu.ups.ppw.negocio.GestionMotocicleta;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author Darwin Cabrera
 */
@Path("rutamotocicleta")
public class ServicioGestionMotocicleta {
	@Inject
	private MotocicletaDAO daoMotocicleta;
	@Inject
	private GestionMotocicleta gestionarMotocicleta;

	@GET
	@Path("datosfinales")
	@Produces("application/json")
	public Motocicleta datosMotocicleta() {
		Motocicleta moto = new Motocicleta();
		moto.setPlaca("FF1231");
		moto.setMarca("Kawasaki");
		moto.setColor("Amarillo");
		moto.setPrecio(1.231);
		return moto;
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")

	public Response almacenarMotocicleta(Motocicleta motocicleta) {
		try {
			gestionarMotocicleta.guardarMotocicleta(motocicleta);
			return Response.status(Response.Status.OK).entity(motocicleta).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Error error = new Error();
			error.setCodigoError(99);
			error.setMensajeError("Error al intentar guardar los datos: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}

	}

	@GET
	@Path("listafinal")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Motocicleta> listadoMotocicleta() {
		return daoMotocicleta.obtenerMotocicleta();
	}
}
