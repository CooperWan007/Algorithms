package simpleGA2;

import common.Conf;

public class MainTest {
	public static void main(String[] args) {
		//create cities data
		CitiesManager.createData();
		
		//initialize population
		Population popu=new Population(Conf.populationSize, true);
		System.out.println("Initial distance: "+popu.getFittest().calcDistance());
		
		//evolve the population for 100 generations
		for(int i=0;i<100;++i){
			popu=Evolution.evolPopulation(popu);
		}
		
		System.out.println("Finished.");
        System.out.println("Final distance: " + popu.getFittest().calcDistance());
        System.out.println("Solution:");
        System.out.println(popu.getFittest());
	}
}
