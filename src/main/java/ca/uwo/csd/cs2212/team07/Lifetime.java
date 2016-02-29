package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;

/**
 * Lifetime class, this class stores data of the user's lifetime information. Total distance that they traveled,
 * total floors climbed and steps taken
 * @author Team07
 */
public class Lifetime implements Serializable {

    //Instance Variables, declared as public final so that they can be accessed easily but not changed
    private double distance;
    private double floors;
    private long steps;

    /**
     * Constructor Method: makes a new Lifetime object
     * @param lifeDistance distance that user has traveled while using Fitbit
     * @param lifeFloors floors that user has climbed while using Fitbit
     * @param lifeSteps steps that user has taken while using Fitbit
     */
    public Lifetime(double lifeDistance, double lifeFloors, long lifeSteps) {
        this.distance = lifeDistance;
        this.floors = lifeFloors;
        this.steps = lifeSteps;
    }

    /**
     * toString method: used for testing.
     * @return String containing info about Lifetime object
     */
    public String toString() {
        return "Lifetime Distance: " + this.distance + "\nLifetime Floors: " + this.floors + "\nLifetime Steps: " + this.steps;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFloors() {
        return floors;
    }

    public void setFloors(double floors) {
        this.floors = floors;
    }

    public long getSteps() {
        return steps;
    }

    public void setSteps(long steps) {
        this.steps = steps;
    }

    
}
