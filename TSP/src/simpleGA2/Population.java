package simpleGA2;
/*
 * manages a population
 */
public class Population {
	//holds a population of tour
	Tour[] tours;
	
	//constructs a population
	public Population(int populationSize, boolean initialize) {
		// TODO Auto-generated constructor stub
		tours=new Tour[populationSize];
		//initialize a population
		if(initialize){
			//loop and create tours
			for(int i=0;i<getPopulationSize();++i){
				Tour tour=new Tour();
				tour.generateTour();//generate a random tour
				saveTour(i, tour);
			}
		}
	}
	
	//get the size of population
	public int getPopulationSize(){
		return tours.length;
	}
	
	//save a tour to population
	public void saveTour(int index,Tour tour){
		tours[index]=tour;
	}
	
	//get a tour from population
	public Tour getTour(int index){
		return (Tour)tours[index];
	}
	
	//get the fittest tour from population
	public Tour getFittest(){
		Tour fittest=tours[0];
		//loop through tours to find fittest
		for(int i=0;i<getPopulationSize();++i){
			if(fittest.calcFitness() <=getTour(i).calcFitness()){
				fittest=getTour(i);
			}
		}
		return fittest;
	}
}
