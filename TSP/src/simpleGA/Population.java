package simpleGA;
/*
 * Manages all individuals of a population
 */
public class Population {
	Individual[] individuals;
	
	//generate a population
	public Population(int populationSize, boolean initialize) {
		// TODO Auto-generated constructor stub
		individuals=new Individual[populationSize];
		//initialize the population
		if(initialize){
			for(int i=0;i<populationSize;++i){
				Individual individual=new Individual();
				individual.generateIndividual();
				saveIndividual(i, individual);
			}
		}
	}
	
	//get individual in a specific position
	public Individual getIndividual(int index){
		return individuals[index];
	}
	
	//get the fittest individual
	public Individual getFittest(){
		Individual fittest=individuals[0];
		for(int i=0;i<getSize();++i){
			// the bigger the fitness value, the fitter the individual.
			if(fittest.getFitness() <= getIndividual(i).getFitness()){
				fittest=getIndividual(i);
			}
		}
		return fittest;
	}
	
	//set individual to a population
	public void saveIndividual(int index,Individual individual){
		individuals[index]=individual;
	}
	
	//get the population size
	public int getSize(){
		return individuals.length;
	}
}
