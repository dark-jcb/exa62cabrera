/**
 * 
 */
package ec.edu.ups.ppw.datos;
import java.io.Serializable;
import java.util.List;
import ec.edu.ups.ppw.modelo.Motocicleta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * @author Darwin Cabrera
 */

@Stateless
public class MotocicletaDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	public void insertarMotocicleta(Motocicleta motocicleta) {
		em.persist(motocicleta);
	}

	public void actualizarMotocicleta(Motocicleta motocicleta) {
		em.merge(motocicleta);
	}

	public Motocicleta leerMotocicleta(String placaMotocicleta) {
		Motocicleta m = em.find(Motocicleta.class, placaMotocicleta);
		return m;
	}

	public List<Motocicleta> obtenerMotocicleta() {
		String jpql = "SELECT m FROM MOTOCICLETA M";
		Query q = em.createQuery(jpql, Motocicleta.class);
		return q.getResultList();
	}
}
