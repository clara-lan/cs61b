import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {

    private double mean;
    private double stddev;

    public PercolationStats(int N, int T,  PercolationFactory pf){
        Percolation newPf = pf.make(N);
        if(N <= 0 || T <= 0){
            throw new java.lang.IllegalArgumentException();
        }


    }

    public double mean(){
        return 0.0;
    }


}
