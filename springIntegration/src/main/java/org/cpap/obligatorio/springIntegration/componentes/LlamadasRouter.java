package org.cpap.obligatorio.springIntegration.componentes;

import org.apache.log4j.Logger;
import org.cpap.obligatorio.springIntegration.dominio.CompaniaEnum;
import org.cpap.obligatorio.springIntegration.dominio.Llamada;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

@MessageEndpoint
public class LlamadasRouter {
	private static final Logger logger = Logger.getLogger(LlamadasRouter.class);
	
	@Router(inputChannel = "llamadasFilterOutputChannel")
	public String route(Llamada llamada) {
		if (getCompania(llamada.getNumeroDestino()).equals(CompaniaEnum.ANTEL)) {
		    logger.info("Llamada a ANTEL");		 
			return "antelRouterChannel";
		} else if (getCompania(llamada.getNumeroDestino()).equals(CompaniaEnum.MOVISTAR))  {
		    logger.info("Llamada a MOVISTAR");		 
			return "movistarRouterChannel";
		} 
	    logger.info("Llamada a CLARO");		 
		return "claroRouterChannel";
	}

	private CompaniaEnum getCompania(String numero) {
		if(numero.startsWith("099") || numero.startsWith("091") || numero.startsWith("098")) {
			return CompaniaEnum.ANTEL;
		} else if(numero.startsWith("094") || numero.startsWith("095")) {
			return CompaniaEnum.MOVISTAR;
		}
		return CompaniaEnum.CLARO;
	}
	
}
