package com.perched.peacock.parking.api.request;

/**
 * 
 * @author pnvamshi
 *
 */

public class IncomingVehicleInfoRequest {

	private String vehicleNumber;
	
	private Double vehicleWeight;
	
	private String parkingLotId;
	

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Double getVehicleWeight() {
		return vehicleWeight;
	}

	public void setVehicleWeight(Double vehicleWeight) {
		this.vehicleWeight = vehicleWeight;
	}

	public String getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
	}
}
