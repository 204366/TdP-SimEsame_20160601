package it.polito.tdp.flight.model;

public class TestModel {

	public static void main(String[] args) {
		Model m = new Model();
		m.getAllRouteAirline(new Airline(0,null, null));
		
		System.out.println("******************");
		System.out.println(m.getAirportRaggiungibili(new Airline(0,null, null)));
		System.out.println("******************");
		System.out.println(m.getAllAirportRaggiungibiliFromAirport(new Airport(28,"Bagotville","Bagotville","Canada", "YBG", "CYBG", 48.330555, -70.996391, 0, null, null),new Airline(0,null, null)));
	}

}
