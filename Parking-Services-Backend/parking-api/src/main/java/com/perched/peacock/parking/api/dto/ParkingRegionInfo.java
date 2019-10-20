package com.perched.peacock.parking.api.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author pnvamshi
 *
 */

public class ParkingRegionInfo {

	private String parkingRegion;
	private String parkingLotId;

	public String getParkingRegion() {
		return parkingRegion;
	}

	public void setParkingRegion(String parkingRegion) {
		this.parkingRegion = parkingRegion;
	}

	public String getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
