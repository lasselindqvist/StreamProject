package architecture;

import java.util.HashMap;
import java.util.Map;

public class PerformableReturnValue {

	public PerformableReturnValue() {
		this.map = new HashMap<>();
	}

	private Map<String, Object> map;

	public Object getReturnValue(String name) {
		return this.map.get(name);
	}

	public Object setReturnValue(String name, Object value) {
		return this.map.put(name, value);
	}
}
