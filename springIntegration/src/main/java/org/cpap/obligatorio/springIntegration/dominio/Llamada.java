package org.cpap.obligatorio.springIntegration.dominio;

public class Llamada {

	private Long id;
	private String numeroDestino;
	private String numeroOrigen;
	private Long duracion;
	private Float precio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroDestino() {
		return numeroDestino;
	}
	public void setNumeroDestino(String numeroDestino) {
		this.numeroDestino = numeroDestino;
	}
	public String getNumeroOrigen() {
		return numeroOrigen;
	}
	public void setNumeroOrigen(String numeroOrigen) {
		this.numeroOrigen = numeroOrigen;
	}
	public Long getDuracion() {
		return duracion;
	}
	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	
	
	
}
