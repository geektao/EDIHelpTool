package tonyx.Tools.Config;

import java.util.ArrayList;
import java.util.List;

final public class ConfigChoice {
	private String CFGminOccurs;
	private String CFGmaxOccurs;
	private List<ConfigItem> CGFchoice;

	public ConfigChoice() {
		CGFchoice = new ArrayList<ConfigItem>();
	}

	public List<ConfigItem> getCGFchoice() {
		return CGFchoice;
	}

	public void setCGFchoice(ConfigItem cGFchoice) {
		CGFchoice.add(cGFchoice);
	}

	public String getCFGminOccurs() {
		return CFGminOccurs;
	}

	public void setCFGminOccurs(String cFGminOccurs) {
		CFGminOccurs = cFGminOccurs;
	}

	public String getCFGmaxOccurs() {
		return CFGmaxOccurs;
	}

	public void setCFGmaxOccurs(String cFGmaxOccurs) {
		CFGmaxOccurs = cFGmaxOccurs;
	}
}
