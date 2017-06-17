package it.polito.tdp.flight.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.flight.db.FlightDAO;

public class Model {
	private FlightDAO dao = new FlightDAO();
	private DirectedWeightedMultigraph<Airport,DefaultWeightedEdge> graph;
	private  Map<Integer,Airport> airports;
	
	
	public Model() {
		List<Airport> temp = dao.getAllAirports();
		airports = new TreeMap<Integer,Airport>();
		for(Airport a : temp )
			airports.put(a.getAirportId(), a);
	}
	public List<Airline> getAllAirline(){
		return dao.getAllAirline();
	}
	public List<Route> getAllRouteAirline(Airline a ){
		return dao.getAllRouteOfAirline(a);
	}
	
	public  void createGraph(Airline a){
		graph = new DirectedWeightedMultigraph<Airport, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		
		for(Airport temp : airports.values()){
			graph.addVertex(temp);
		}
		List<Route> routes = dao.getAllRouteOfAirline(a);
	
		for(Route r : routes ){
			Airport s =this.airports.get(r.getSourceAirportId());
			Airport d =this.airports.get(r.getDestinationAirportId());
			if (d != null && s != null){
				LatLng c1 = new LatLng(s.getLatitude(),s.getLongitude());
				LatLng c2 = new LatLng(d.getLatitude(),d.getLongitude());
				double distance = LatLngTool.distance(c1, c2, LengthUnit.KILOMETER);
				
				if(graph.containsVertex(s) && graph.containsVertex(d) && !graph.containsEdge(s, d)){
					DefaultWeightedEdge e = graph.addEdge(s, d);
					graph.setEdgeWeight(e, distance);
					
				}
			}
		}
		return;
	}
	public Set<Airport> getAirportRaggiungibili(Airline a){
		
		return dao.getAllAirportRaggiunti(a);
	}
	
	public List<AirportDistance> getAllAirportRaggiungibiliFromAirport(Airport a, Airline ai){
		List<AirportDistance> trovati = new ArrayList<AirportDistance>();
		List<Airport>raggiungibili = new ArrayList<>(this.getAirportRaggiungibili(ai));
		
		for(Airport temp : raggiungibili){
			if(!temp.equals(a)){
				DijkstraShortestPath<Airport, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<Airport, DefaultWeightedEdge>(this.graph, a , temp);
				GraphPath<Airport, DefaultWeightedEdge> path = dijkstra.getPath();
				if(path != null){
					
					trovati.add(new AirportDistance(temp, path.getWeight(), path.getEdgeList().size()));
				}
			}
		}
		trovati.sort(new Comparator<AirportDistance>(){

			@Override
			public int compare(AirportDistance a0, AirportDistance a1) {
				// TODO Auto-generated method stub
				return Double.compare(a0.getDistanza(), a1.getDistanza());
			}
			
		});
		return trovati;
	}

	public Map<Integer, Airport> getAirports() {
		return airports;
	}
	
	
}
