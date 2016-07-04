package org.cpap.obligatorio.springIntegration.componentes;

import java.util.List;

import org.apache.log4j.Logger;
import org.cpap.obligatorio.springIntegration.dominio.Llamada;
import org.cpap.obligatorio.springIntegration.dominio.Llamadas;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;

@MessageEndpoint
public class LlamadasSplitter {

	private static final Logger logger = Logger.getLogger(LlamadasSplitter.class);
	
	@Splitter(inputChannel = "llamadasChannel", outputChannel = "llamadasSplitterOutputChannel")
	public List<Llamada> splitLlamadas(Message<Llamadas> message) {
		List<Llamada> llamadas = message.getPayload().getLlamadas();
		logger.info("Dentro del Splitter, separando el mensaje en " + message.getPayload().getLlamadas().size() + " mensajes");
		return llamadas;
	}
}
