package common;
/*
 * Manages Configuration
 */
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conf {
	//data
	public static String data_dirname = "./data";
	public static String result_dirname = "./result";
	public static File data_dir;	
	public static File result_dir;
	public static File algo_dir;
	public static File model_dir;
	public static File log_dir;
	
	//basic
	public static String algo="";
	public static int seed = 3;
	public static Random rnd=new Random(seed);
	public static final long timeLimit = 7200 * 1000;
	public static final double RC_EPS = 1e-5; //  where tolerance is 1e-4 or 1e-9
	public static final boolean debug = true;
	public static int attributes=10; //attributes of activity for figuring out the similarity
	public static SimpleDateFormat df=new SimpleDateFormat("yyyymmddhhmmss"); //alter the form of system's time
	
	
	//Parameters in CPLEX
	public static int CPLEX_TreLim = 10000;
	public static int CPLEX_NodeFileInd = 2;
	
	//Parameters in GA
	public static int populationSize=50;
	public static int defaultGeneLength=20;
	public static final double crossoverRate=0.5; //crossover probability
	public static final double mutationRate=0.015; //mutation probability
	public static final int tournamentSize=5; //tournament size
	public static final boolean elitism=true; //survival of the fittest
	public static int tournamntSize=5;
	public static int elitismSize=5;
	public static int childSize=5;
	public static int evolveGenerations=100;
	
	//make directories
	public static void makeDirs(){
		data_dir=new File(Conf.data_dirname);
		if(!data_dir.isDirectory())
			data_dir.mkdir();
		result_dir = new File(Conf.result_dirname);
		if (!result_dir.isDirectory())
			result_dir.mkdir();
		algo_dir = new File(result_dir, Conf.getAlgoName());
		algo_dir.mkdir();
		model_dir = new File(algo_dir, "Model");
		model_dir.mkdir();
		log_dir = new File(algo_dir, "Log");
		log_dir.mkdir();
	}
	//get algorithm name
	public static String getAlgoName() {
		return algo;
	}
	
	//get the current time
	public static String currentTime() {
		//convert the time to string
		return new Date().toString();
	}
	
	//get the remaining time
	public static long getRemainTime(long timeLimit, long startTime) {
		return Math.max(0, startTime + timeLimit - System.currentTimeMillis());
	}
	
	//convert a double number to integer form (3.00-->3)
	public static int toInteger(double d) {
		int i = (int) Math.round(d);
		if(!isInteger(d)){
			System.out.println("Not an Integer!");
		}
		return i;
			
	}
	
	//convert a double array to integer form
	public static int[] toIntegers(double[] d) {
		int[] a = new int[d.length];
		for (int i = 0; i < d.length; ++i) {
			a[i]=(int)Math.round(d[i]);
			if (!isInteger(d[i])) {
				System.out.println("Not an Integer array!");
			}
		}
		return a;
	}
	
	//check whether the double number is equal to an integer
	public static boolean isInteger(double d) {
		int i = (int) Math.round(d);
		if (Math.abs(d - i) <= Conf.RC_EPS) {
			return true;
		} else {
			return false;
		}
	}
	
	//check whether the double array is equal to an integer array
	public static boolean areIntegers(double[] d) {
		for (int i = 0; i < d.length; i++) {
			if(!isInteger(d[i]))
				return false;
		}
		return true;
	}
	
	//check if the string is equal to a decimal
	public static boolean isNumeric(String str){
		 Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if(!isNum.matches()){
		       return false; 
		   } 
		   return true; 
	}
	
	//cut and keep the integer number from a string
	public static int cutNumeric(String str){
		int temp=0;
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(str);
		temp=Integer.parseInt(m.replaceAll("").trim());
		return temp;
	}
	
	//generate a integer number from a to b with step size c :[a,b]
	public static int randomInt(int a, int b, int c){
		int temp;
		int count=(b-a)/c;
		temp = a+ rnd.nextInt(count+1)*c;
		return temp;
	}
	
	//generate a decimal number from a to b with step size c
	public static double randomDecimal(double a, double b, double c){
		double temp;
		int count=(int)((b-a)/c);
		temp = a+ rnd.nextInt(count+1)*c; //[0,count+1)
		return temp;
	}
	
	//keep three decimals 
	public static double formatDemo(double a, int i){
		double temp;
		double t=Math.pow(10, i);
		temp=Math.round(a*t)/t;
		return temp;
	}
	
	
}
