package org.cpap.obligatorio.springIntegration.componentes;

import org.apache.log4j.Logger;
import org.cpap.obligatorio.springIntegration.dominio.CompaniaEnum;
import org.cpap.obligatorio.springIntegration.dominio.Llamada;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class LlamadasProcessor {

	private static final Logger logger = Logger.getLogger(LlamadasProcessor.class);
	
	@ServiceActivator(inputChannel = "antelRouterChannel", outputChannel = "llamadasCalculadasOutputChannel")
	public Llamada procesarAntel(Llamada llamada) {
		llamada.setPrecio(llamada.getDuracion() / 60 * CompaniaEnum.ANTEL.getPrecio());
		logger.info("Precio llamada al número " + llamada.getNumeroDestino() + " es de " + llamada.getPrecio());
		return llamada;
	}


	@ServiceActivator(inputChannel = "movistarRouterChannel", outputChannel = "llamadasCalculadasOutputChannel")
	public Llamada procesarMovistar(Llamada llamada) {
		llamada.setPrecio((llamada.getDuracion() / 60) * CompaniaEnum.MOVISTAR.getPrecio());
		logger.info("Precio llamada al número " + llamada.getNumeroDestino() + " es de " + llamada.getPrecio());
		return llamada;
	}


	@ServiceActivator(inputChannel = "claroRouterChannel", outputChannel = "llamadasCalculadasOutputChannel")
	public Llamada procesarClaro(Llamada llamada) {
		llamada.setPrecio((llamada.getDuracion() / 60) * CompaniaEnum.CLARO.getPrecio());
		logger.info("Precio llamada al número " + llamada.getNumeroDestino() + " es de " + llamada.getPrecio());
		return llamada;
	}

}
