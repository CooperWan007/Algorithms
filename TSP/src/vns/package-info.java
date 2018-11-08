/**
 * This is a variable neighborhood search algorithm applied to the classic traveling salesman problem.
 * In this algorithm. we'll combine the metaheuristic and cplex.
 * Cplex will be used for getting an initial solution, and in shaking procedure as well as for the neighborhood exploration step.
 * Variable neighborhood search is composed of two parts:
 * first, shaking procedure;
 * second, variable neighborhood descent, which is the main part of VNS.
 * The core of VNS is the change of neighborhood structure. 
 */
/**
 * @author dell
 *
 */
package vns;