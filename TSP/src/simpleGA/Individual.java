package simpleGA;

import common.Conf;

/*
 * Manages an individual
 */
public class Individual {
	//binary genetic algorithm
	private byte[] genes=new byte[Conf.defaultGeneLength];
	private int fitness=0; //fitness value
	
	//generate an individual randomly
	public void generateIndividual(){
		for(int i=0;i<genes.length;++i){
			byte gene=(byte)Math.round(Math.random());
			/*
			 * math.round():四舍五入
			 * math.random():0-1的任意小数
			 * Math.round(Math.random()):0或1
			 */
			genes[i]=gene;
			
		}
	}
	
	//get the gene in a specific position
	public byte getGene(int index){
		return genes[index];
	}
	
	//set a value to the gene in a specific position
	public void setGene(int index, byte gene){
		genes[index]=gene;
		fitness=0;
	}
	
	//get genes length
	public int getSize(){
		return genes.length;
	}
	
	//get fitness value
	public int getFitness(){
		if(fitness ==0 ){
			fitness=FitnessCalc.calcFitness(this);
		}
		return fitness;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String geneString="";
		for(int i=0;i<getSize();++i){
			geneString += getGene(i);
		}
		return geneString;
	}
}
