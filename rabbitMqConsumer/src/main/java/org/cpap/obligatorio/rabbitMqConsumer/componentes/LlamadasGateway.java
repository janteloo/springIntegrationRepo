package org.cpap.obligatorio.rabbitMqConsumer.componentes;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "llamadasGateway", defaultRequestChannel = "rabbitMqChannel")
public interface LlamadasGateway {

	@Gateway(requestChannel="rabbitMqChannel")
	public void procesar();
}
