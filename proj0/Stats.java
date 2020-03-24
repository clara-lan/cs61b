import java.util.concurrent.atomic.DoubleAccumulator;

public class Stats{
  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    double[] a = new double[n];
    for ( int i = 0; i < n; i++){
      a[i] = StdIn.readDouble();
    }
    double sum = 0.0;
    for(int i = 0; i < n; i++){
      sum += a[i];
    }
    double mean = sum / n;
    double sum2 = 0.0;
    for (int i = 0; i < n; i++){
      sum2 += (a[i] - mean) * (a[i] - mean);
    }
    double stddev = Math.sqrt(sum2 / (n-1));
    StdOut.println("Mean:" + mean);
    StdOut.println("Standard deviation:" + stddev);
  }
}