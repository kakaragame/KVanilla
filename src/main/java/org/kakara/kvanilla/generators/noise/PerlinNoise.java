package org.kakara.kvanilla.generators.noise;

/**
 * Thanks to Nick Banks for the c++ code.
 * https://stackoverflow.com/questions/4753055/perlin-noise-generation-for-terrain
 */
public class PerlinNoise {

    private double persistence, frequency, amplitude, octaves;
    private int randomSeed;

    public PerlinNoise() {

    }

    public PerlinNoise(double persistence, double frequency, double amplitude, double octaves, int randomSeed) {
        this.persistence = persistence;
        this.frequency = frequency;
        this.amplitude = amplitude;
        this.octaves = octaves;
        this.randomSeed = 2 + randomSeed * randomSeed;
    }

    public double getPersistence() {
        return persistence;
    }

    public double getFrequency() {
        return frequency;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public double getOctaves() {
        return octaves;
    }

    public int getSeed() {
        return randomSeed;
    }

    public double getHeight(double x, double y) {
        return amplitude * total(x, y);
    }

    private double total(double i, double j) {
        double t = 0;
        double amplitude = 1;
        double freq = frequency;
        for (int k = 0; k < octaves; k++) {
            t += getValue(j * freq + randomSeed, i * freq + randomSeed) * amplitude;
            amplitude *= persistence;
            freq *= 2;
        }
        return t;
    }

    private double getValue(double x, double y) {
        int Xint = (int) x;
        int Yint = (int) y;
        double Xfrac = x - Xint;
        double Yfrac = y - Yint;

        //noise values
        double n01 = noise(Xint - 1, Yint - 1);
        double n02 = noise(Xint + 1, Yint - 1);
        double n03 = noise(Xint - 1, Yint + 1);
        double n04 = noise(Xint + 1, Yint + 1);
        double n05 = noise(Xint - 1, Yint);
        double n06 = noise(Xint + 1, Yint);
        double n07 = noise(Xint, Yint - 1);
        double n08 = noise(Xint, Yint + 1);
        double n09 = noise(Xint, Yint);

        double n12 = noise(Xint + 2, Yint - 1);
        double n14 = noise(Xint + 2, Yint + 1);
        double n16 = noise(Xint + 2, Yint);

        double n23 = noise(Xint - 1, Yint + 2);
        double n24 = noise(Xint + 1, Yint + 2);
        double n28 = noise(Xint, Yint + 2);

        double n34 = noise(Xint + 2, Yint + 2);

        //find the noise values of the four corners
        double x0y0 = 0.0625 * (n01 + n02 + n03 + n04) + 0.125 * (n05 + n06 + n07 + n08) + 0.25 * (n09);
        double x1y0 = 0.0625 * (n07 + n12 + n08 + n14) + 0.125 * (n09 + n16 + n02 + n04) + 0.25 * (n06);
        double x0y1 = 0.0625 * (n05 + n06 + n23 + n24) + 0.125 * (n03 + n04 + n09 + n28) + 0.25 * (n08);
        double x1y1 = 0.0625 * (n09 + n16 + n28 + n34) + 0.125 * (n08 + n14 + n06 + n24) + 0.25 * (n04);

        //interpolate between those values according to the x and y fractions
        double v1 = interpolate(x0y0, x1y0, Xfrac); //interpolate in x direction (y)
        double v2 = interpolate(x0y1, x1y1, Xfrac); //interpolate in x direction (y+1)
        double fin = interpolate(v1, v2, Yfrac);  //interpolate in y direction

        return fin;
    }

    private double interpolate(double x, double y, double a) {

        double negA = 1.0 - a;
        double negASqr = negA * negA;
        double fac1 = 3.0 * (negASqr) - 2.0 * (negASqr * negA);
        double aSqr = a * a;
        double fac2 = 3.0 * aSqr - 2.0 * (aSqr * a);

        return x * fac1 + y * fac2; //add the weighted factors
    }

    private double noise(int x, int y) {
        int n = x + y * 57;
        n = (n << 13) ^ n;
        int t = (n * (n * n * 15731 + 789221) + 1376312589) & 0x7fffffff;
        return 1.0 - ((double) t) * 0.931322574615478515625e-9;
    }


}
