import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solver for the Flight problem (#9) from CS 61B Spring 2018 Midterm 2.
 * Assumes valid input, i.e. all Flight start times are >= end times.
 * If a flight starts at the same time as a flight's end time, they are
 * considered to be in the air at the same time.
 */
public class FlightSolver{

    PriorityQueue<Event> pq;
    ArrayList<Flight> flights;

    class Event{
        int time;
        int diff; // save passenger number as diff

        Event(int time, int diff) {
            this.time = time;
            this.diff = diff;
        }
    }

    public FlightSolver (ArrayList<Flight> flights){
        //save flights using PQ
        // based on lect20 p20
        /* FIX ME */
        // equal to lambda
//        PriorityQueue<Event> pq = new PriorityQueue<>(new Comparator<Event>() {
//            @Override
//            public int compare(Event o1, Event o2) {
//                return o1.time - o2.time;
//            }
//        })
        this.flights = flights;
        pq = new PriorityQueue<>((a, b) -> a.time - b.time);//use lambda to define comparator, if a.time - b.time < 0, a then b


    }

    public int solve() {
        /* FIX ME */
        for(Flight f: flights) {
            pq.add(new Event(f.startTime, f.passengers));
            pq.add(new Event(f.endTime, -f.passengers));
        }
        int max = 0;
        int cur = 0;
        while(!pq.isEmpty()){
            cur += pq.poll().diff;
            max = Math.max(cur, max);
        }
        return max;
    }


}
