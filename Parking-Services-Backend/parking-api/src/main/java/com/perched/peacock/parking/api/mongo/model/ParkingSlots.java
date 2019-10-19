package com.perched.peacock.parking.api.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author pnvamshi
 *
 */

@Document(collection = "PARKED_SLOTS")
public class ParkingSlots {

	private String parkingRegion;
	
	private long totalSlots;
	
	private long availableSlots;
	
	private String pakingLotId;

	public String getParkingRegion() {
		return parkingRegion;
	}

	public void setParkingRegion(String parkingRegion) {
		this.parkingRegion = parkingRegion;
	}

	public long getTotalSlots() {
		return totalSlots;
	}

	public void setTotalSlots(long totalSlots) {
		this.totalSlots = totalSlots;
	}

	public long getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(long availableSlots) {
		this.availableSlots = availableSlots;
	}

	public String getPakingLotId() {
		return pakingLotId;
	}

	public void setPakingLotId(String pakingLotId) {
		this.pakingLotId = pakingLotId;
	}
	
}
