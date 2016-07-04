package org.cpap.obligatorio.rabbitMqConsumer.componentes;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {

	@Autowired
	private AmqpAdmin admin;
	@Autowired
	private AmqpTemplate template;

	private static final Logger logger = Logger.getLogger(RabbitMqConsumer.class);

	public void obtenerPrecioFinal() {
		admin.declareQueue(new Queue("llamadasRabbitQueue"));
		Float precioFinal = (Float) template.receiveAndConvert();
		logger.info("Precio final de todas las llamadas, obtenido remotamente: " + precioFinal);		
	}

}
