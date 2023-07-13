/**
 * 
 */
package ec.edu.ups.ppw.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Darwin Cabrera
 */
@Entity
public class Motocicleta implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "moto_placa")
	private String placa;
	
	@Column(name = "moto_marca")
	private String marca;

	@Column(name = "moto_color")
	private String color;

	@Column(name = "moto_precio")
	private double precio;



	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Motocicleta [placa=" + placa + ", color=" + color + ", precio=" + precio + ", marca=" + marca + "]";
	}

}
