package simpleGA;

import common.Conf;

/*
 * this is about how to calculate the fitness value of an individual
 */
public class FitnessCalc {
	//a candidate solution: this is a expected genes
	static byte[] solution=new byte[Conf.defaultGeneLength];
	
	//set a byte array as a candidate solution
	static void setSolution(byte[] newSolution){
		solution=newSolution;
	}
	
	//set a string as a candidate solution
	static void setSolution(String newSoluiton){
		solution=new byte[newSoluiton.length()];
		//loop through each character of the String and save it to the byte array
		for(int i=0;i<newSoluiton.length();++i){
			//get the character form i to i+1
			String character=newSoluiton.substring(i, i+1);
			//ÈÝ´í
			if(character.contains("0")||character.contains("1")){
				solution[i]=Byte.parseByte(character);
			}else{
				solution[i]=0;
			}
		}
	}
	
	//we hope to obtain the expected genes.
	//calculate the fitness value by comparing the individual with candidate solution
	//the way of calculating fitness will be more complicated in a more complex problem
	static int calcFitness(Individual individual){
		int fitness=0;
		for(int i=0;i<individual.getSize() && i<solution.length;++i){
			if(individual.getGene(i) == solution[i]){
				fitness++;
			}
		}
		return fitness;
	}
	
	//get optimum fitness, i.e., the length of candidate solution
	static int getMaxFitness(){
		int maxFitness=solution.length;
		return maxFitness;
	}
}
