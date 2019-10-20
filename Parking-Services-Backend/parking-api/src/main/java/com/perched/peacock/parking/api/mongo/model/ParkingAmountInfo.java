package com.perched.peacock.parking.api.mongo.model;

/**
 * 
 * @author pnvamshi
 *
 */

public class ParkingAmountInfo {

	private String parkingLotId;
	private long parkingFee;

	public String getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
	}

	public long getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(long parkingFee) {
		this.parkingFee = parkingFee;
	}

}
