package org.misoenergy.ria.binding;

/**
 * <p>
 * FuelCategory distinguishes the different categories of electricity generation
 * fuel.
 * </p>
 * <p>
 * The "Other" FuelCategory is the combination of hydroelectric, pumped storage
 * hydroelectric, diesel, demand response resources, external asynchronous
 * resources, and a varied assortment of solid waste/garbage/wood-pulp burners.
 * </p>
 */
public enum FuelCategory {
	COAL, NATURAL_GAS, NUCLEAR, OTHER, WIND;

	/**
	 * CATEGORY values from XML data have spaces and mixed case, which does not
	 * translate well to the default {@link #valueOf(String)} method. This
	 * method performs appropriate String manipulations before calling
	 * {@link #valueOf(String)}.
	 * 
	 * @param str
	 *            CATEGORY String from FuelMix XML.
	 * @return FuelCategory appropriate for provided String.
	 */
	public static FuelCategory valueOfGenMix(String str) {
		return FuelCategory.valueOf(str.toUpperCase().replaceAll(" ", "_"));
	}
}
