package org.cpap.obligatorio.springIntegration.dominio;

public enum CompaniaEnum {

	ANTEL(1f),
	MOVISTAR(1.50f),
	CLARO(2f);
	
	private Float precio;

	private CompaniaEnum(Float precio) {
		this.precio = precio;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	

	
	
}
