public enum Planet {
    MERCURY (3.303e+23, 2.4397e6,  57e6),
    VENUS   (4.869e+24, 6.0518e6, 108e6),
    EARTH   (5.976e+24, 6.3781e6, 15e60),
    MARS    (6.421e+23, 3.3972e6, 228e6),
    JUPITER (1.900e+27, 7.1492e7, 779e6),
    SATURN  (5.688e+26, 6.0268e7, 143e9),
    URANUS  (8.686e+25, 2.5559e7, 288e9),
    NEPTUNE (1.024e+26, 2.4746e7, 45e90);
//  PLUTO   (1.303e+22, 1187, 591e9);         // sorry pluto. Moved to MinorPlanet enum

    private final double mass;          // in kilograms
    private final double radius;        // in meters
    private final double distance;      // in K meters

    Planet(double mass, double radius, double distance) {
        this.mass = mass;
        this.radius = radius;
        this.distance = distance;
    }
    double mass() { return mass; }
    double radius() { return radius; }
    double distance() { return distance; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }

    @Override
    public String toString() {
        return "Planet "  + super.toString() +
                " { mass=" + mass +
                ", radius=" + radius +
                ", distance=" + distance +
                " }";
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java enums.Planet <earth_weight>");
            System.exit(-1);
        }

        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("    Your weight on %8s is %6.2f%n", p, p.surfaceWeight(mass));
            if (p == MERCURY)
                System.out.printf("    %s's radius is %e%n", p, p.radius());
        }
    }
}
