package org.cpap.obligatorio.rabbitMqConsumer.componentes;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint
public class RabbitMqConsumer {

	private Logger logger = Logger.getLogger(RabbitMqConsumer.class);

	@ServiceActivator(inputChannel="rabbitMqChannel")
	public void obtenerPrecioFinal(Message<?> message) {
		logger.info("Resultado final: " + message.getPayload());
	}

}
