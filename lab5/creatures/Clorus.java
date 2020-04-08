package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.randomEntry;

public class Clorus extends huglife.Creature {
    private int r;
    private int g;
    private int b;

    public Clorus(double e){
        super("clorus");
        r = 34;
        b = 231;
        g = 0;
        energy = e;
    }

    public Clorus() {
        this(2);
    }


    public Color color() {
   // always return r34 g0 b231
        return color(34,0,231);
    }


    public void attack(Creature c) {
        // do nothing.
    }


    public void move() {
        // TODO
        //lose 0.03 on move
        energy -= 0.03;

    }


    public void stay() {
        // TODO
        // lose 0.01 one stay
        energy -= 0.01;
        if(energy < 0){
            energy = 0;
        }
    }


    public Clorus replicate() {
        // save for now
        Clorus newC = new Clorus();
        // copy energy
        energy /= 2;
        newC.energy = energy;
        return newC;
    }


    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        boolean anyPlip = false;
        // TODO
        // (Google: Enhanced for-loop over keys of NEIGHBORS?)
        for(Direction key:neighbors.keySet()){
            if(neighbors.get(key).name().equals("empty")){
                emptyNeighbors.add(key);
            }else if (neighbors.get(key).name().equals("plip")){
                // if any plip, change to true
                anyPlip = true;
            }
        }

        if (emptyNeighbors.size()!=0) { //
            if(anyPlip){
                // Rule 2, attack plip
                // HINT: randomEntry(emptyNeighbors)
                return new Action(Action.ActionType.ATTACK, randomEntry(emptyNeighbors));
            }else if(energy >= 1){
                // Rule 3, replicate when energy > 1
                return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
            }else{
                return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
            }

        }


        // Rule 1, stay when no empty neighbor
        else{
            return new Action(Action.ActionType.STAY);
        }
    }
}
