// FastNoise.java
//
// MIT License
//
// Copyright(c) 2017 Jordan Peck
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files(the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions :
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
// The developer's email is jorzixdan.me2@gzixmail.com (for great email, take
// off every 'zix'.)
//

package org.kakara.kvanilla.mod.generators;

public class NoiseGenerator {
    private int seed;
    private float frequency;

    public NoiseGenerator(int seed, float frequency) {
        this.seed = seed;
        this.frequency = frequency;
    }

    private static int fastFloor(float f) {
        return (f >= 0 ? (int) f : (int) f - 1);
    }

    public float getNoiseValue(float x, float y, float z) {
        x *= frequency;
        y *= frequency;
        z *= frequency;

        float t = (x + y + z) * F3;
        int i = fastFloor(x + t);
        int j = fastFloor(y + t);
        int k = fastFloor(z + t);

        t = (i + j + k) * G3;
        float x0 = x - (i - t);
        float y0 = y - (j - t);
        float z0 = z - (k - t);

        int i1, j1, k1;
        int i2, j2, k2;

        if (x0 >= y0) {
            if (y0 >= z0) {
                i1 = 1;
                j1 = 0;
                k1 = 0;
                i2 = 1;
                j2 = 1;
                k2 = 0;
            } else if (x0 >= z0) {
                i1 = 1;
                j1 = 0;
                k1 = 0;
                i2 = 1;
                j2 = 0;
                k2 = 1;
            } else {
                i1 = 0;
                j1 = 0;
                k1 = 1;
                i2 = 1;
                j2 = 0;
                k2 = 1;
            }
        } else {
            if (y0 < z0) {
                i1 = 0;
                j1 = 0;
                k1 = 1;
                i2 = 0;
                j2 = 1;
                k2 = 1;
            } else if (x0 < z0) {
                i1 = 0;
                j1 = 1;
                k1 = 0;
                i2 = 0;
                j2 = 1;
                k2 = 1;
            } else // x0 >= z0
            {
                i1 = 0;
                j1 = 1;
                k1 = 0;
                i2 = 1;
                j2 = 1;
                k2 = 0;
            }
        }

        float x1 = x0 - i1 + G3;
        float y1 = y0 - j1 + G3;
        float z1 = z0 - k1 + G3;
        float x2 = x0 - i2 + F3;
        float y2 = y0 - j2 + F3;
        float z2 = z0 - k2 + F3;
        float x3 = x0 + G33;
        float y3 = y0 + G33;
        float z3 = z0 + G33;

        float n0, n1, n2, n3;

        t = (float) 0.6 - x0 * x0 - y0 * y0 - z0 * z0;
        if (t < 0) n0 = 0;
        else {
            t *= t;
            n0 = t * t * calculateGradCoordinate3D(seed, i, j, k, x0, y0, z0);
        }

        n1 = calculateN(seed, i, j, k, i1, j1, k1, x1, y1, z1);

        n2 = calculateN(seed, i, j, k, i2, j2, k2, x2, y2, z2);

        t = (float) 0.6 - x3 * x3 - y3 * y3 - z3 * z3;
        if (t < 0) n3 = 0;
        else {
            t *= t;
            n3 = t * t * calculateGradCoordinate3D(seed, i + 1, j + 1, k + 1, x3, y3, z3);
        }

        return 32 * (n0 + n1 + n2 + n3);
    }

    public float getNoiseValue(float x, float y) {
        x *= frequency;
        y *= frequency;

        float t = (x + y) * F2;
        int i = fastFloor(x + t);
        int j = fastFloor(y + t);

        t = (i + j) * G2;
        float X0 = i - t;
        float Y0 = j - t;

        float x0 = x - X0;
        float y0 = y - Y0;

        int i1, j1;
        if (x0 > y0) {
            i1 = 1;
            j1 = 0;
        } else {
            i1 = 0;
            j1 = 1;
        }

        float x1 = x0 - i1 + G2;
        float y1 = y0 - j1 + G2;
        float x2 = x0 - 1 + F2;
        float y2 = y0 - 1 + F2;

        float n0, n1, n2;

        t = (float) 0.5 - x0 * x0 - y0 * y0;
        if (t < 0) n0 = 0;
        else {
            t *= t;
            n0 = t * t * calculateGradCoordinate2D(seed, i, j, x0, y0);
        }

        t = (float) 0.5 - x1 * x1 - y1 * y1;
        if (t < 0) n1 = 0;
        else {
            t *= t;
            n1 = t * t * calculateGradCoordinate2D(seed, i + i1, j + j1, x1, y1);
        }

        t = (float) 0.5 - x2 * x2 - y2 * y2;
        if (t < 0) n2 = 0;
        else {
            t *= t;
            n2 = t * t * calculateGradCoordinate2D(seed, i + 1, j + 1, x2, y2);
        }

        return 50 * (n0 + n1 + n2);
    }

    private final static float F2 = (float) (1.0 / 2.0);
    private final static float G2 = (float) (1.0 / 4.0);
    private final static float F3 = (float) (1.0 / 3.0);
    private final static float G3 = (float) (1.0 / 6.0);
    private final static float G33 = G3 * 3 - 1;

    private final static int X_PRIME = 1619;
    private final static int Y_PRIME = 31337;
    private final static int Z_PRIME = 6971;

    private static class Float2 {
        public final float x, y;

        public Float2(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Float3 {
        public final float x, y, z;

        public Float3(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static final Float2[] GRAD_2D = {
            new Float2(-1, -1), new Float2(1, -1), new Float2(-1, 1), new Float2(1, 1),
            new Float2(0, -1), new Float2(-1, 0), new Float2(0, 1), new Float2(1, 0),
    };

    private static final Float3[] GRAD_3D = {
            new Float3(1, 1, 0), new Float3(-1, 1, 0), new Float3(1, -1, 0), new Float3(-1, -1, 0),
            new Float3(1, 0, 1), new Float3(-1, 0, 1), new Float3(1, 0, -1), new Float3(-1, 0, -1),
            new Float3(0, 1, 1), new Float3(0, -1, 1), new Float3(0, 1, -1), new Float3(0, -1, -1),
            new Float3(1, 1, 0), new Float3(0, -1, 1), new Float3(-1, 1, 0), new Float3(0, -1, -1),
    };

    private static int calculateGradHash(int seed, int x, int y, int z, boolean is3d) {
        int hash = seed;
        hash ^= X_PRIME * x;
        hash ^= Y_PRIME * y;
        if (is3d) hash ^= Z_PRIME * z;

        hash = hash * hash * hash * 60493;
        hash = (hash >> 13) ^ hash;

        return hash;
    }

    private static float calculateGradCoordinate2D(int seed, int x, int y, float xd, float yd) {
        Float2 g = GRAD_2D[calculateGradHash(seed, x, y, 0, false) & 7];

        return xd * g.x + yd * g.y;
    }

    private static float calculateGradCoordinate3D(int seed, int x, int y, int z, float xd, float yd, float zd) {
        Float3 g = GRAD_3D[calculateGradHash(seed, x, y, z, true) & 15];

        return xd * g.x + yd * g.y + zd * g.z;
    }

    private float calculateN(int seed, int i, int j, int k, int i2, int j2, int k2, float x2, float y2, float z2) {
        float t;
        float n2;
        t = (float) 0.6 - x2 * x2 - y2 * y2 - z2 * z2;
        if (t < 0) n2 = 0;
        else {
            t *= t;
            n2 = t * t * calculateGradCoordinate3D(seed, i + i2, j + j2, k + k2, x2, y2, z2);
        }
        return n2;
    }
}