package org.cpap.obligatorio.rabbitMqConsumer.aplicacion;

import org.cpap.obligatorio.rabbitMqConsumer.componentes.LlamadasGateway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumirMensaje {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LlamadasGateway gateway = (LlamadasGateway) context.getBean("llamadasGateway");
		gateway.procesar();
	}
}
 