package name.reidmiller.misoreports;

import name.reidmiller.misoreports.client.FuelMixClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MisoPublicReportsBindingsConfig {
	static Logger logger = LogManager
			.getLogger(MisoPublicReportsBindingsConfig.class.getName());

	/**
	 * FuelMix
	 * 
	 * @return
	 */
	public static FuelMixClient fuelMixClient() {
		return new FuelMixClient(
				"https://www.misoenergy.org/ria/FuelMix.aspx?XML=True");
	}
}
