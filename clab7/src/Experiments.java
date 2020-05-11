/**
 * Created by hug.
 */

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Experiments {
    public static void experiment1() {
        Random r = new Random();
        // init a new bst
        BST<Integer> bst = new BST<>();
        List<Double> yVal= new ArrayList<>();// real depth,y1
        List<Double> y2Val = new ArrayList<>(); // expected avg depth,y2
        List<Integer> xVal = new ArrayList<>();// number of nodes,x
        yVal.add(0.0);
        y2Val.add(0.0);
        xVal.add(0);
        for(int i = 1; i<=5000; i++){
            // insert new node into bst
            ExperimentHelper.getInt(bst);

            xVal.add(i);
            yVal.add(bst.avgDepth());
            y2Val.add(ExperimentHelper.optimalAverageDepth(i));
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("x label").yAxisTitle("y label").build();
        chart.addSeries("Real depth)", xVal, yVal);
        chart.addSeries("Expected depth", xVal, y2Val);
        new SwingWrapper(chart).displayChart();
    }

    public static void experiment2() {
        BST<Integer> test  = new BST<>();
        int temp = 0;
        int count = 0;
        while(count < 5000){
            count ++;
            ExperimentHelper.getInt(test);
        }
        double start_depth = test.avgDepth();
        List<Double> yVal = new ArrayList<>();
        List<Integer> xVal = new ArrayList<>();
        xVal.add(0);
        yVal.add(start_depth);

        for(int x = 1; x<=5000;x+=1){
            test.deleteTakingSuccessor(test.getRandomKey());
            ExperimentHelper.getInt(test);
            xVal.add(x);
            yVal.add(test.avgDepth());
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("x label").yAxisTitle("y label").build();

        chart.addSeries("Optimal depth", xVal, yVal);
        new SwingWrapper(chart).displayChart();


    }

    public static void experiment3() {
        BST<Integer> test_bst = new BST<>();
        int temp = 0;
        int count = 0;
        while(count < 5000){
            count ++;
            ExperimentHelper.getInt(test_bst);
        }
        double start_depth = test_bst.avgDepth();
        List<Double> yVal = new ArrayList<>();
        List<Integer> xVal = new ArrayList<>();
        xVal.add(0);
        yVal.add(start_depth);


        for(int x = 1; x<=5000;x+=1){
            test_bst.deleteTakingRandom(test_bst.getRandomKey());
            ExperimentHelper.getInt(test_bst);
            xVal.add(x);
            yVal.add(test_bst.avgDepth());
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("x label").yAxisTitle("y label").build();

        chart.addSeries("Optimal depth", xVal, yVal);
        new SwingWrapper(chart).displayChart();

    }

    public static void main(String[] args) {
        experiment3();
    }
}
