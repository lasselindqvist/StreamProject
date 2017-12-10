package architecture;

import java.util.HashMap;
import java.util.Map;

public class PerformableParameters {

	public PerformableParameters() {
		this.map = new HashMap<>();
	}

	private Map<String, Object> map;

	public Object getParameter(String name) {
		return this.map.get(name);
	}

	public Object setParameter(String name, Object value) {
		return this.map.put(name, value);
	}

}
