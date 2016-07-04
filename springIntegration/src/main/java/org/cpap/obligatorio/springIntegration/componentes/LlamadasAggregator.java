package org.cpap.obligatorio.springIntegration.componentes;

import java.util.List;

import org.apache.log4j.Logger;
import org.cpap.obligatorio.springIntegration.dominio.Llamada;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.MessageEndpoint;

@MessageEndpoint
public class LlamadasAggregator {

	private static final Logger logger = Logger.getLogger(LlamadasAggregator.class);
	
	@Aggregator(inputChannel = "llamadasCalculadasOutputChannel" , outputChannel = "llamadasDeliveryChannel")
	public Float calcularPrecioTotal(List<Llamada> llamadas) {
		logger.info("Aggregator calculando el precio final...");
		Float precioTotal = 0F;
		for(Llamada llamada : llamadas) {
			precioTotal = precioTotal + llamada.getPrecio();
		}
		
		return precioTotal;
	}
}
