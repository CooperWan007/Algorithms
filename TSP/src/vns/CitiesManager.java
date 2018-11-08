package vns;

import java.util.ArrayList;

/*
 * manages all the city data (namely, a complete tour)
 */
public class CitiesManager {
	private ArrayList<City> cities = new ArrayList<City>();

	public ArrayList<City> createData() {
		// create and add cities data
		cities.add(new City(60, 200));
		cities.add(new City(180, 200));
		cities.add(new City(80, 180));
		cities.add(new City(140, 180));
		cities.add(new City(20, 160));
		cities.add(new City(100, 160));
		cities.add(new City(200, 160));
		cities.add(new City(140, 140));
		cities.add(new City(40, 120));
		cities.add(new City(100, 120));
		cities.add(new City(180, 100));
		cities.add(new City(60, 80));
		cities.add(new City(120, 80));
		cities.add(new City(120, 80));
		cities.add(new City(180, 60));
		cities.add(new City(100, 40));
		cities.add(new City(200, 40));
		cities.add(new City(20, 20));
		cities.add(new City(60, 20));
		cities.add(new City(160, 20));
		return cities;
	}

	// add a destination city
	public void addCity(City city) {
		cities.add(city);
	}

	// get a city in a given position
	public City getCity(int index) {
		return (City) cities.get(index);
	}

	// get the number of destination cities
	public int numberOfCities() {
		return cities.size();
	}

}
