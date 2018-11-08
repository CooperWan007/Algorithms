/**
 * It is a simple algorithm about how the genetic algorithm runs
 * Some concepts about GA£º
 * 	Individual--Chromosome--binary String
 * 		gene
 * 		gene position
 * 		gene feature
 * 	Population
 * 		population size
 * 	Evolution:
 * 		selection
 * 		crossover
 * 		mutation
 */
/**
 * The procedure of GA:
 *	generate an initial population randomly
 *	determine the fitness of each individual
 *	perform selection
 *	repeat
 *   perform crossover
 *   perform mutation
 *   determine the fitness of each individual
 *   perform selection
 *	until some stopping criterion applies	
 */
/**
 * @author dell
 * probably, there are four classes,
 * 	Population--Manages all individuals of a population
 * 	Individual--Manages an individual
 *  Evolution--Manages our evolution algorithms such as crossover and mutation
 *  FitnessCalc--Allows us set a candidate solution and calculate an individual's fitness
 *  
 *  @param defaultGeneLength
 *  @param population size 30-160
 *  @param crossover probability 0.25-0.75
 *  @param mutation probability 0.01-0.2
 */
package simpleGA;