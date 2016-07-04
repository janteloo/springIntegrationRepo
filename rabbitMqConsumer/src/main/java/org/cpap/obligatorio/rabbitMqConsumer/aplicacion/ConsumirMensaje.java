package org.cpap.obligatorio.rabbitMqConsumer.aplicacion;

import org.cpap.obligatorio.rabbitMqConsumer.componentes.RabbitMqConsumer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumirMensaje {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		RabbitMqConsumer consumer = (RabbitMqConsumer) context.getBean("rabbitMqConsumer");
		consumer.obtenerPrecioFinal();
	}
}
 