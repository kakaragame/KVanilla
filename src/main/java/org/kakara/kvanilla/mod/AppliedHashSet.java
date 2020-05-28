package org.kakara.kvanilla.mod;

import java.util.Arrays;
import java.util.HashSet;

public class AppliedHashSet<E> extends HashSet<E> {
					@SafeVarargs
					AppliedHashSet(E... items) {
										addAll(Arrays.asList(items));
					}
}
