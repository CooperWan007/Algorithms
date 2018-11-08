package simpleGA;

import common.Conf;

/*
 * Manages our evolution algorithms such as crossover and mutation
 */
public class Evolution {
	//evolution of a population
	public static Population evolPopulation(Population popu){
		//generate a new population (not initialization)
		Population newPopulation=new Population(Conf.populationSize, false);
		
		//keep the best individual first
		if(Conf.elitism){
			newPopulation.saveIndividual(0, popu.getFittest());
		}
		int elitismOffset;
		if(Conf.elitism){
			elitismOffset=1;
		}else{
			elitismOffset=0;
		}
		
		//loop over the population size and create new individual with crossover
		for(int i=elitismOffset;i<popu.getSize();++i){
			Individual indiv1=tournamentSelection(popu);
			Individual indiv2=tournamentSelection(popu);
			Individual newIndividual=crossover(indiv1, indiv2);
			newPopulation.saveIndividual(i, newIndividual);
		}
		
		//mutate
		for(int i=elitismOffset;i<newPopulation.getSize();++i){
			mutation(newPopulation.getIndividual(i));
		}
		
		return newPopulation;
	}
	
	//crossover individuals
	private static Individual crossover(Individual indiv1,Individual indiv2){
		Individual newIndvidual=new Individual();
		//loop through genes
		for(int i=0;i<indiv1.getSize();++i){
			//crossover
			if(Math.random() <=Conf.crossoverRate){
				newIndvidual.setGene(i, indiv1.getGene(i));
			}else{
				newIndvidual.setGene(i, indiv2.getGene(i));
			}
		}
		return newIndvidual;
	}
	
	//mutate an individual
	private static void mutation(Individual indiv){
		//loop through genes
		for(int i=0;i<indiv.getSize();++i){
			if(Math.random() <= Conf.mutationRate){
				//generate a gene randomly
				byte gene=(byte)Math.round(Math.random());
				indiv.setGene(i, gene);
			}
		}
	}
	
	//select individuals for crossover
	private static Individual tournamentSelection(Population popu){
		//create a tournament population
		Population tournamentPopu=new Population(Conf.tournamentSize, false);
		//for each place in the tournament, get a random individual from parent population
		for(int i=0;i<Conf.tournamentSize;++i){
			int randomId=(int)(Math.random()* popu.getSize());//Math.random():[0,1)
			tournamentPopu.saveIndividual(i, popu.getIndividual(randomId));
		}
		//find the best of tournamentPopu
		Individual fittest=tournamentPopu.getFittest();
		return fittest;
	}
}
