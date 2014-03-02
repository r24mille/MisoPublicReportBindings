package name.reidmiller.misoreports.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.misoenergy.ria.binding.FuelMix;

/**
 * The FuelMix report represents the percentage of total megawatts supplied by
 * the listed resources in the MISO footprint.
 */
public class FuelMixClient {
	private Logger logger = LogManager.getLogger(this.getClass());
	private String defaultUrlString;

	public FuelMixClient(String defaultUrlString) {
		this.defaultUrlString = defaultUrlString;
	}

	/**
	 * Unmarshals XML data into Java objects using JAXB. This method is a
	 * wrapper around {@link #getFuelMix(String)}.
	 * 
	 * @return FuelMix data from MISO's real-time public XML reports located at
	 *         {@link #defaultUrlString}.
	 */
	public FuelMix getDefaultFuelMix() {
		return this.getFuelMix(defaultUrlString);
	}

	/**
	 * Unmarshals XML data into Java objects using JAXB.
	 * 
	 * @param urlString
	 *            XML report location.
	 * @return FuelMix data from MISO's real-time public XML reports located at
	 *         the URL provided.
	 */
	public FuelMix getFuelMix(String urlString) {
		FuelMix fuelMix = null;

		try {
			JAXBContext context = JAXBContext.newInstance(FuelMix.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			URL url = new URL(urlString);
			fuelMix = (FuelMix) unmarshaller.unmarshal(url.openStream());
		} catch (JAXBException e) {
			logger.error("Unmarshalling error: " + e.getLocalizedMessage());
		} catch (MalformedURLException e) {
			logger.error("Error creating URL object: "
					+ e.getLocalizedMessage());
		} catch (IOException e) {
			logger.error("Data InputStream from URL error: "
					+ e.getLocalizedMessage());
		}

		return fuelMix;
	}

}
