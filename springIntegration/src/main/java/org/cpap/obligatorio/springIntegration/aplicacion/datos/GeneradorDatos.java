package org.cpap.obligatorio.springIntegration.aplicacion.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.cpap.obligatorio.springIntegration.dominio.Llamada;
import org.cpap.obligatorio.springIntegration.dominio.Llamadas;

public class GeneradorDatos {

	public static Llamadas generarLlamadas() {
		Llamadas llamadas = new Llamadas();
		llamadas.setLlamadas(obtenerLlamadas());
		return llamadas;
	}
	
	private static List<Llamada> obtenerLlamadas() {
		List<Llamada> llamadas = new ArrayList<Llamada>();
		String[] arrayNumeros = {"091", "098", "099", "094", "095", "096", "097"};
		for(Integer i = 0; i < 500; i++) {
			Llamada llamada = new Llamada();
			llamada.setId(i + 1L);
			
			//Se genera el número
			Random random = new Random();
			String prefijo = arrayNumeros[random.nextInt(arrayNumeros.length - 1)];
			StringBuilder telefonoBuilder = new StringBuilder();
			telefonoBuilder.append(prefijo);
			for(int x = 0; x < 6; x++ ) {
				telefonoBuilder.append(random.nextInt(9));
			}
			
			llamada.setNumeroDestino(telefonoBuilder.toString());
			
			StringBuilder telefonoOrigen = new StringBuilder();
			telefonoOrigen.append(arrayNumeros[random.nextInt(2)]);
			for(int x = 0; x < 6; x++ ) {
				telefonoOrigen.append(random.nextInt(9));
			}
			llamada.setNumeroOrigen(telefonoOrigen.toString());
			llamada.setDuracion(new Integer(random.nextInt(1000)).longValue());
			llamadas.add(llamada);
		}
		
		llamadas.get(400).setDuracion(0L);
		
		return llamadas;
	}
}
