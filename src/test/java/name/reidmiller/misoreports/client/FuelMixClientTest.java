package name.reidmiller.misoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import name.reidmiller.misoreports.MisoPublicReportsBindingsConfig;

import org.junit.Test;
import org.misoenergy.ria.binding.FuelMix;
import org.misoenergy.ria.binding.FuelType;

public class FuelMixClientTest {

	@Test
	public void testGetDefaultFuelMix() {
		FuelMixClient fuelMixClient = MisoPublicReportsBindingsConfig.fuelMixClient();
		FuelMix fuelMix = fuelMixClient.getDefaultFuelMix();
		
		assertNotNull("FuelMix is null", fuelMix);
		assertTrue("Total MW is not greater than 0", fuelMix.getTotalMW() > 0);
		assertNotNull("List of FuelType objects is null", fuelMix.getFuelTypes());
		
		for (FuelType fuelType: fuelMix.getFuelTypes()) {
			assertTrue("Act (actual?) FuelType output is not greater than 0", fuelType.getAct() > 0);
			assertNotNull("FuelCategory is null", fuelType.getFuelCategory());
			assertNotNull("FuelType Date is null", fuelType.getIntervalEst());
			assertTrue("FuelType Date is not before current instant", fuelType.getIntervalEst().before(new Date()));
		}
	}

}
