package org.misoenergy.ria.binding;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FuelMix")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class FuelMix implements Serializable {
	private static final long serialVersionUID = -6158469628011739963L;
	private double totalMW;
	private List<FuelType> fuelTypes;

	@Override
	public String toString() {
		StringBuffer stringBuf = new StringBuffer();
		stringBuf.append("\"FuelMix\": {");
		stringBuf.append("\"totalMW\": " + this.totalMW + ", ");
		stringBuf.append("\"fuelTypes\": [");
		for (FuelType fuelType : fuelTypes) {
			stringBuf.append("{" + fuelType.toString() + "}, ");
		}
		stringBuf.append("] }");
		return stringBuf.toString();
	}

	@XmlAttribute(name = "TotalMW")
	public double getTotalMW() {
		return totalMW;
	}

	public void setTotalMW(double totalMW) {
		this.totalMW = totalMW;
	}

	@XmlElement(name = "Type")
	@XmlElementWrapper(name = "Fuel")
	public List<FuelType> getFuelTypes() {
		return fuelTypes;
	}

	public void setFuelTypes(List<FuelType> fuelTypes) {
		this.fuelTypes = fuelTypes;
	}
}
