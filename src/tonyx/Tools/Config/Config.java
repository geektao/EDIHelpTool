package tonyx.Tools.Config;

import java.util.ArrayList;
import java.util.List;

final public class Config {
	private List<ConfigElement> CFGElement;

	public Config() {
		CFGElement = new ArrayList<ConfigElement>();
	}

	public List<ConfigElement> getCFGElement() {
		return CFGElement;
	}

	public void setCFGElement(ConfigElement cFGElement) {
		CFGElement.add(cFGElement);
	}
}
