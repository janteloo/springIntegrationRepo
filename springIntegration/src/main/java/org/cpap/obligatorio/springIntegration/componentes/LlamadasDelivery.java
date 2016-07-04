package org.cpap.obligatorio.springIntegration.componentes;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class LlamadasDelivery {
	
 
	private static final Logger logger = Logger.getLogger(LlamadasDelivery.class);

	@ServiceActivator(inputChannel = "llamadasDeliveryChannel", outputChannel = "rabbitMqChannel")
	public Float delivery(Float precioFinal) {
		logger.info("Precio final de todas las llamadas: " + precioFinal);
		logger.info("La respuesta se envía a través de un channel adapter");
		return precioFinal;
	}
}
