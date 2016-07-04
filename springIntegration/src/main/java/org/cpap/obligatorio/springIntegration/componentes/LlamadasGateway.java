package org.cpap.obligatorio.springIntegration.componentes;

import org.cpap.obligatorio.springIntegration.dominio.Llamadas;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "llamadasGateway", defaultRequestChannel = "llamadasChannel")
public interface LlamadasGateway {

	@Gateway(requestChannel="llamadasChannel")
	public void procesar(Llamadas llamadas);
}
