/**
 * 
 */
package ec.edu.ups.ppw.negocio;
import java.util.List;
import ec.edu.ups.ppw.datos.MotocicletaDAO;
import ec.edu.ups.ppw.modelo.Motocicleta;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

/**
 * @author Darwin Cabrera
 */

@Singleton
@Startup
public class DatosMotocicleta {
	@Inject
	private MotocicletaDAO daoMotocicleta;

	@PostConstruct
	public void init() {
		Motocicleta m1 = new Motocicleta();
		m1.setPlaca("BB2121");
		m1.setColor("Verde");
		m1.setMarca("Yamaha");
		m1.setPrecio(2.220);
		daoMotocicleta.insertarMotocicleta(m1);
		Motocicleta m2 = new Motocicleta();
		m2.setPlaca("AA0000");
		m2.setColor("Azul");
		m2.setMarca("Suzuki");
		m2.setPrecio(2.681);
		daoMotocicleta.insertarMotocicleta(m2);

		Motocicleta m3 = new Motocicleta();
		m3.setPlaca("DD2132");
		m3.setColor("Rojo");
		m3.setMarca("BMW");
		m3.setPrecio(1.909);
		daoMotocicleta.insertarMotocicleta(m3);

		Motocicleta m4 = new Motocicleta();
		m4.setPlaca("CC2212");
		m4.setColor("Negro");
		m4.setMarca("Ducati");
		m4.setPrecio(1.359);
		daoMotocicleta.insertarMotocicleta(m4);
		List<Motocicleta> listarMotocicleta = daoMotocicleta.obtenerMotocicleta();
		System.out.println("--------------MOTOCICLETAS:--------------");
		for (Motocicleta moto : listarMotocicleta) {
			System.out.println(moto);
		}
	}
}
