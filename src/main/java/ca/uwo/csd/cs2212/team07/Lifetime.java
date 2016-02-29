package ca.uwo.csd.cs2212.team07;

public class Lifetime {

    public final double distance;
    public final double floors;
    public final long steps;

    public Lifetime(double lifeDistance, double lifeFloors, long lifeSteps) {
        this.distance = lifeDistance;
        this.floors = lifeFloors;
        this.steps = lifeSteps;
    }

    public String toString() {

        return "Lifetime Distance: " + this.distance + "\nLifetime Floors: " + this.floors + "\nLifetime Steps: " + this.steps;
    }

}
