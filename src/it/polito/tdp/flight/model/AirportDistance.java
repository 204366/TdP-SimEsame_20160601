package it.polito.tdp.flight.model;

public class AirportDistance {
	
	private Airport airport;
	private double distanza;
	private int tratte;
	public AirportDistance(Airport airport, double distanza, int tratte) {
		super();
		this.airport = airport;
		this.distanza = distanza;
		this.tratte = tratte;
	}
	public Airport getAirport() {
		return airport;
	}
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	public double getDistanza() {
		return distanza;
	}
	public void setDistanza(double distanza) {
		this.distanza = distanza;
	}
	public int getTratte() {
		return tratte;
	}
	public void setTratte(int tratte) {
		this.tratte = tratte;
	}
	@Override
	public String toString() {
		return "AirportDistance [airport=" + airport + ", distanza=" + distanza + "]";
	}
	
	

}
