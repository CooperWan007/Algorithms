package simpleGA;

import common.Conf;

//tester
public class MainTest {
	public static void main(String[] args) {
		//design a candidate solution by yourself
		FitnessCalc.setSolution("1111000000000000000000000000000000000000000000000000000000001111");
		
		//initialize a population
		Population myPopu=new Population(Conf.populationSize, true);
		
		//iteration
		int generationCount=0;
		//stopping criterion: repeat until get the expected candidate solution
		while(myPopu.getFittest().getFitness() < FitnessCalc.getMaxFitness()){
			generationCount++;
			System.out.println("Generation: "+ generationCount+", Fittest vallue: "+myPopu.getFittest().getFitness());
			myPopu=Evolution.evolPopulation(myPopu);
		}
		System.out.println("Solution found!");
		System.out.println("Final Fittest Genes:");
		System.out.println(myPopu.getFittest());

	}
}
