package util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Util {

	public static <T, U> Map<T, U> emptyIfNull(final Map<T, U> map) {
		return map == null ? Collections.<T, U>emptyMap() : map;
	}
	
	public static <T> Set<T> emptyIfNull(final Set<T> set) {
		return set == null ? Collections.<T>emptySet() : set;
	}
	
	public static <T> List<T> emptyIfNull(final List<T> list) {
		return list == null ? Collections.<T>emptyList() : list;
	}

}
