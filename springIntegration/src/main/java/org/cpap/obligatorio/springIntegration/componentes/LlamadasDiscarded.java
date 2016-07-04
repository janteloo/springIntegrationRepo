package org.cpap.obligatorio.springIntegration.componentes;

import org.apache.log4j.Logger;
import org.cpap.obligatorio.springIntegration.dominio.Llamada;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class LlamadasDiscarded {
	private static final Logger logger = Logger.getLogger(LlamadasDiscarded.class);

	@ServiceActivator(inputChannel = "llamadasFilterDiscardChannel", outputChannel = "llamadasCalculadasOutputChannel")
	public Llamada handleDiscarded(Llamada llamada) {
		logger.info("Se descarta mensaje por tener una duración igual a 0, no es necesario realizar cálculos");
		llamada.setPrecio(0f);
		return llamada;
	}

}
