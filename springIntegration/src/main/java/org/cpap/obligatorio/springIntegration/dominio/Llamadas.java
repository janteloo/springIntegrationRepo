package org.cpap.obligatorio.springIntegration.dominio;

import java.util.ArrayList;
import java.util.List;

public class Llamadas {

	private List<Llamada> llamadas;

	public Llamadas() {
		llamadas = new ArrayList<Llamada>();
	}
	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(List<Llamada> llamadas) {
		this.llamadas = llamadas;
	}
	
	public void add(Llamada llamada) {
		llamadas.add(llamada);
	}
}
