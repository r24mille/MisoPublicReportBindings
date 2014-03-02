package org.misoenergy.ria.binding;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.misoenergy.ria.binding.FuelCategory;

public class FuelCategoryTest {

	@Test
	public void testValueOfGenMix() {
		assertEquals("valueOf(\"Coal\") cannot be parsed into enum",
				FuelCategory.COAL, FuelCategory.valueOfGenMix("Coal"));
		assertEquals("valueOf(\"Natural Gas\") cannot be parsed into enum",
				FuelCategory.NATURAL_GAS, FuelCategory.valueOfGenMix("Natural Gas"));
		assertEquals("valueOf(\"Nuclear\") cannot be parsed into enum",
				FuelCategory.NUCLEAR, FuelCategory.valueOfGenMix("Nuclear"));
		assertEquals("valueOf(\"Other\") cannot be parsed into enum",
				FuelCategory.OTHER, FuelCategory.valueOfGenMix("Other"));
		assertEquals("valueOf(\"Wind\") cannot be parsed into enum",
				FuelCategory.WIND, FuelCategory.valueOfGenMix("Wind"));
	}

}
