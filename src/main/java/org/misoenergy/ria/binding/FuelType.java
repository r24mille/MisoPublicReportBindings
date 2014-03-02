package org.misoenergy.ria.binding;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class FuelType implements Serializable {
	private static final long serialVersionUID = -7880522565035277780L;
	public static final String FUEL_MIX_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
	private Logger logger = LogManager.getLogger(this.getClass());
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			FUEL_MIX_DATE_PATTERN);
	private Date intervalEst;
	private String intervalEstString;
	private FuelCategory fuelCategory;
	private String fuelCategoryString;
	private double act;

	@Override
	public String toString() {
		StringBuffer stringBuf = new StringBuffer();
		stringBuf.append("\"FuelType\": {");
		stringBuf.append("\"intervalEst\": \"" + this.intervalEst + "\", ");
		stringBuf.append("\"fuelCategory\": \"" + this.fuelCategory + "\", ");
		stringBuf.append("\"act\": " + this.act);
		stringBuf.append("}");
		return stringBuf.toString();
	}

	@XmlAttribute(name = "INTERVALEST")
	public String getIntervalEstString() {
		return intervalEstString;
	}
	
	public void setIntervalEstString(String intervalEstString) {
		this.intervalEstString = intervalEstString;
		try {
			this.intervalEst = simpleDateFormat.parse(intervalEstString);
		} catch (ParseException e) {
			logger.error("Could not parse Date from String: "
					+ e.getLocalizedMessage());
		}
	}
	
	@XmlTransient
	public Date getIntervalEst() {
		return intervalEst;
	}

	public void setIntervalEst(Date intervalEst) {
		this.intervalEst = intervalEst;
	}

	@XmlAttribute(name = "CATEGORY")
	public String getFuelCategoryString() {
		return fuelCategoryString;
	}
	
	public void setFuelCategoryString(String fuelCategoryString) {
		this.fuelCategoryString = fuelCategoryString;
		this.fuelCategory = FuelCategory.valueOfGenMix(fuelCategoryString);
	}
	
	@XmlTransient
	public FuelCategory getFuelCategory() {
		return fuelCategory;
	}

	public void setFuelCategory(FuelCategory fuelCategory) {
		this.fuelCategory = fuelCategory;
	}

	@XmlAttribute(name = "ACT")
	public double getAct() {
		return act;
	}

	public void setAct(double act) {
		this.act = act;
	}

}
