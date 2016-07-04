package org.cpap.obligatorio.springIntegration.componentes;

import org.cpap.obligatorio.springIntegration.dominio.Llamada;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;

@MessageEndpoint
public class LlamadasFilter {
	
	@Filter(inputChannel = "llamadasSplitterOutputChannel", outputChannel = "llamadasFilterOutputChannel", discardChannel = "llamadasFilterDiscardChannel")
	public boolean filterLlamada(Llamada llamada) {
		return llamada.getDuracion() > 0;
	}

}
