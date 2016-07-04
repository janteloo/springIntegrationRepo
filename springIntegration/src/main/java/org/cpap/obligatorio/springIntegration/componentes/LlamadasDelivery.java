package org.cpap.obligatorio.springIntegration.componentes;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class LlamadasDelivery {
	
	@Autowired private AmqpAdmin admin;
	@Autowired private AmqpTemplate template;
 
	private static final Logger logger = Logger.getLogger(LlamadasDelivery.class);

	@ServiceActivator(inputChannel = "llamadasDeliveryChannel")
	public void delivery(Float precioFinal) {
		logger.info("Precio final de todas las llamadas: " + precioFinal);

		admin.declareQueue( new Queue("llamadasRabbitQueue") );
		logger.info("Se envía el precio a cola remota de Rabbit MQ");
		template.convertAndSend(precioFinal);
	}
}
