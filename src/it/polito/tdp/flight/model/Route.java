package it.polito.tdp.flight.model;

public class Route {
	
	private String airline ;
	private int airlineId ;
	private String sourceAirport ;
	private int sourceAirportId ;
	private String destinationAirport ;
	private int destinationAirportId ;
	private String codeshare ;
	private int stops ;
	private String equipment ;
	
	public Route(String airline, int airlineId, String sourceAirport, int sourceAirportId, String destinationAirport,
			int destinationAirportId, String codeshare, int stops, String equipment) {
		super();
		this.airline = airline;
		this.airlineId = airlineId;
		this.sourceAirport = sourceAirport;
		this.sourceAirportId = sourceAirportId;
		this.destinationAirport = destinationAirport;
		this.destinationAirportId = destinationAirportId;
		this.codeshare = codeshare;
		this.stops = stops;
		this.equipment = equipment;
	}
	
	public String getAirline() {
		return airline;
	}
	
	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	public int getAirlineId() {
		return airlineId;
	}
	
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	
	public String getSourceAirport() {
		return sourceAirport;
	}
	
	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	
	public int getSourceAirportId() {
		return sourceAirportId;
	}
	
	public void setSourceAirportId(int sourceAirportId) {
		this.sourceAirportId = sourceAirportId;
	}
	
	public String getDestinationAirport() {
		return destinationAirport;
	}
	
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	
	public int getDestinationAirportId() {
		return destinationAirportId;
	}
	
	public void setDestinationAirportId(int destinationAirportId) {
		this.destinationAirportId = destinationAirportId;
	}
	
	public String getCodeshare() {
		return codeshare;
	}
	
	public void setCodeshare(String codeshare) {
		this.codeshare = codeshare;
	}
	
	public int getStops() {
		return stops;
	}
	
	public void setStops(int stops) {
		this.stops = stops;
	}
	
	public String getEquipment() {
		return equipment;
	}
	
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + airlineId;
		result = prime * result + ((codeshare == null) ? 0 : codeshare.hashCode());
		result = prime * result + destinationAirportId;
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + sourceAirportId;
		result = prime * result + stops;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (airlineId != other.airlineId)
			return false;
		if (codeshare == null) {
			if (other.codeshare != null)
				return false;
		} else if (!codeshare.equals(other.codeshare))
			return false;
		if (destinationAirportId != other.destinationAirportId)
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (sourceAirportId != other.sourceAirportId)
			return false;
		if (stops != other.stops)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Route [airline=" + airline + ", airlineId=" + airlineId + ", sourceAirport=" + sourceAirport
				+ ", sourceAirportId=" + sourceAirportId + ", destinationAirport=" + destinationAirport
				+ ", destinationAirportId=" + destinationAirportId + "]";
	}

}