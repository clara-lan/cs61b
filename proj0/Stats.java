import java.util.concurrent.atomic.DoubleAccumulator;

public class Stats{
  public static void main(String[] args){
    // the first input(args[0]) declare size of the input array
    int n = Integer.parseInt(args[0]);
    double[] numbers = new double[n];
    for ( int i = 0; i < n; i++){
      numbers[i] = StdIn.readDouble();
    }
    double sum = 0.0;
    for(int i = 0; i < n; i++){
      sum += numbers[i];
    }
    double mean = sum / n;
    double sum2 = 0.0;
    for (int i = 0; i < n; i++){
      sum2 += (numbers[i] - mean) * (numbers[i] - mean);
    }
    double stddev = Math.sqrt(sum2 / (n-1));
    StdOut.println("Mean:" + mean);
    StdOut.println("Standard deviation:" + stddev);
  }
}