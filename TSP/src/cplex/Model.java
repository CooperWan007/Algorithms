package cplex;

import vns.CitiesManager;
import common.Conf;
import ilog.concert.IloException;
import ilog.concert.IloIntVar;
import ilog.cplex.IloCplex;

/*
 * variables: x_ij binary variables which take value 1 iff arc(i,j) is included in the optimal tour
 */
public class Model {
	IloCplex cplex;
	IloIntVar[][] x;
	int N;
	
	public Model(CitiesManager cities) throws IloException {
		// TODO Auto-generated constructor stub
		cplex=new IloCplex();
		cplex.setParam(IloCplex.IntParam.MIPEmphasis, IloCplex.MIPEmphasis.BestBound); // choose the way
		cplex.setParam(IloCplex.IntParam.NodeFileInd, Conf.CPLEX_NodeFileInd);
		cplex.setParam(IloCplex.DoubleParam.TreLim, Conf.CPLEX_TreLim);
		cplex.setParam(IloCplex.IntParam.Threads, 1);
		cplex.setOut(null);
		this.buildModel(cities);
	}
	
	protected void buildModel(CitiesManager cities) throws IloException{
		//variables setting
		N=cities.numberOfCities();
		x=new IloIntVar[N][N];
		for(int i=0;i<N;++i){
			for(int j=0;j<N;++j){
				x[i][j]=cplex.boolVar("x("+i+","+j+"");
			}
		}
		
	}
	
	public void solve(){
		
	}
}
