package org.cpap.obligatorio.springIntegration.aplicacion;

import org.cpap.obligatorio.springIntegration.aplicacion.datos.GeneradorDatos;
import org.cpap.obligatorio.springIntegration.componentes.LlamadasGateway;
import org.cpap.obligatorio.springIntegration.dominio.Llamadas;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EjecutarAplicacion {

	private static ApplicationContext context;

	public static void main(String[] args) {
		Llamadas llamadas = GeneradorDatos.generarLlamadas();
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		LlamadasGateway gateway = (LlamadasGateway) context.getBean("llamadasGateway");
		gateway.procesar(llamadas);
	}
}
