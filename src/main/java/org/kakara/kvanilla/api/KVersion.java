package org.kakara.kvanilla.api;

public class KVersion {
					private final int major;
					private final int minor;
					private final int patch;

					public KVersion(int major, int minor, int patch) {
										this.major = major;
										this.minor = minor;
										this.patch = patch;
					}

					public int getMajor() {
										return major;
					}

					public int getMinor() {
										return minor;
					}

					public int getPatch() {
										return patch;
					}
}
