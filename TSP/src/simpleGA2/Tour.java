package simpleGA2;

import java.util.ArrayList;
import java.util.Collections;

/*
 * encode a candidate tour
 */
public class Tour {
	private ArrayList<City> tour=new ArrayList<City>();//holds a tour of cities
	private double fitness=0; //fitness value
	private int distance=0; //tour distance
	
	//constructs a blank tour
	public Tour(){
		for(int i=0;i<CitiesManager.numberOfCities();++i){
			tour.add(null);
		}
	}
	
	//constructs a tour by given tour data
	public Tour(ArrayList<City> tour){
		this.tour=tour;
	}
	
	//constructs a random tour
	public void generateTour(){
		//loop through all cities and add them to tour
		for(int i=0;i<CitiesManager.numberOfCities();++i){
			setCity(i, CitiesManager.getCity(i));
		}
		//randomly reorder the tour
		Collections.shuffle(tour);
	}
	
	//gets a city in given position from tour
	public City getCity(int index){
		return (City)tour.get(index);
	}
	
	//sets a city in a certain position
	public void setCity(int index,City city){
		tour.set(index, city);
		//since the tour is altered, we should update the fitness and distance
		fitness=0;
		distance=0;
	}
	
	//gets number of cities on our tour
	public int getTourSize(){
		return tour.size();
	}
	
	//check if our tour contains a city
	public boolean containsCity(City city){
		return tour.contains(city);
	}
	
	//calculates the distance of tour
	public int calcDistance(){
		if(distance == 0){
			int tourDistance=0;
			//loop through all the tour cities
			for(int cityIndex=0;cityIndex<getTourSize();++cityIndex){
				//gets the from_city
			    City fromCity=getCity(cityIndex);
			    //gets the to_city
			    City toCity;
			    //check we're not on our tour's last city, if we are set our tour's final destination city to our starting city
			    if(cityIndex<getTourSize()-1){
			    	toCity=getCity(cityIndex+1);
			    }else{
			    	//we come back to the first city.
			    	toCity=getCity(0);
			    }
			    tourDistance += fromCity.distanceTo(toCity);
			}
			distance=tourDistance;
		}
		return distance;
	}
	
	//calculates the fitness of tour
	public double calcFitness(){
		if(fitness == 0 ){
			fitness = 1/(double)calcDistance();
		}
		return fitness;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String geneString="";
		for(int i=0;i<getTourSize();++i){
			geneString += getCity(i)+" ";
		}
		return geneString;
	}			
}
