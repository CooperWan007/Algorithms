package simpleGA2;

import common.Conf;

/*
 * manages the evolution of population
 */
public class Evolution {
	//evolve a population
	public static Population evolPopulation(Population popu){
		//declare a new population
		Population newPopulation=new Population(popu.getPopulationSize(), false);
		
		//elitism: keep the fittest tour
		if(Conf.elitism){
			newPopulation.saveTour(0, popu.getFittest());
		}
		int elitismOffSet;
		if(Conf.elitism){
			elitismOffSet=1;
		}else{
			elitismOffSet=0;
		}
		
		//loop over the population size and create new tour with crossover
		for(int i=elitismOffSet;i<newPopulation.getPopulationSize();++i){
			//select parents
			Tour parentTour1=tournamentSelection(popu);
			Tour parentTour2=tournamentSelection(popu);
			//crossover for two parents
			Tour childTour=crossover(parentTour1, parentTour2);
			//add the child to newPopulation
			newPopulation.saveTour(i, childTour);
		}
		
		//mutate the newPopulation
		for(int i=elitismOffSet;i<newPopulation.getPopulationSize();++i){		
			mutation(newPopulation.getTour(i));
		}
		return newPopulation;
	}
	
	//crossover--ordered crossover between two parents
	/*
	 * ordered crossover:
	 *  In this crossover method we select a subset from the first parent, 
	 *  and then add that subset to the offspring. 
	 *  Any missing values are then adding to the offspring from the second parent 
	 *  in order that they are found.
	 */
	private static Tour crossover(Tour parentTour1,Tour parentTour2){
		//create a child tour
		Tour childTour=new Tour();
		
		//select a subset from the first parent
		int pos1=(int)(Math.random()*parentTour1.getTourSize());//Math.ramdom():[0,1)
		int pos2=(int)(Math.random()*parentTour1.getTourSize());
		int startPos=Math.min(pos1, pos2);
		int endPos=Math.max(pos1, pos2);
		
		//loop and add this subtour from parentTour1 to childTour
		 for(int i=startPos;i<=endPos;++i){
			 childTour.setCity(i, parentTour1.getCity(i));
		 }
		 
		 //Any missing values are then adding to the offspring from the second parent
		 for(int i=0;i<parentTour2.getTourSize();++i){
			 if(!childTour.containsCity(parentTour2.getCity(i))){
				 for(int j=0;j<childTour.getTourSize();++j){
					 if(childTour.getCity(j)==null){
						 childTour.setCity(j, parentTour2.getCity(i));
						 break;
					 }
				 }
			 }
		 }
		 return childTour;
		
		
	}
	
	//mutate a tour--swap mutation
	/*
	 * swap mutation:
	 *   two location in the route are selected at random 
	 *   then their positions are simply swapped.
	 */
	private static void mutation(Tour tour){
		//loop through cities of a tour
		for(int pos1=0;pos1<tour.getTourSize();++pos1){
			if(Math.random()<=Conf.mutationRate){
				//get a second city randomly
				int pos2=(int)(Math.random()*tour.getTourSize());
				City city1=tour.getCity(pos1);
				City city2=tour.getCity(pos2);
				
				//swap two cities
				tour.setCity(pos1, city2);
				tour.setCity(pos2, city1);
			}
		}
	}
	
	//select tours for crossover
	private static Tour tournamentSelection(Population popu){
		//create a tournament population
		Population tournamentPopu=new Population(Conf.tournamentSize, false);
		//for each place in the tournament, get a random individual from parent population
		for(int i=0;i<Conf.tournamentSize;++i){
			int randomId=(int)(Math.random()* popu.getPopulationSize());//Math.random():[0,1)
			tournamentPopu.saveTour(i, popu.getTour(randomId));
		}
		//find the best of tournamentPopu
		Tour fittest=tournamentPopu.getFittest();
		return fittest;
	}
	
}
