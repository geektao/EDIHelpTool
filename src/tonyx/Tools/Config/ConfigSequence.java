package tonyx.Tools.Config;

import java.util.ArrayList;
import java.util.List;

final public class ConfigSequence {
	private String CFGminOccurs;
	private String CFGmaxOccurs;
	private List<Object> CFGsequence;

	public ConfigSequence() {
		CFGsequence = new ArrayList<Object>();
	}

	public List<Object> getCFGsequence() {
		return CFGsequence;
	}

	public void setCFGsequence(Object cFGsequence) {
		CFGsequence.add(cFGsequence);
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

	public ConfigItem getConfigItem(String objName) {
		for (Object item : CFGsequence) {
			if (item instanceof ConfigItem) {
				ConfigItem im = (ConfigItem) item;
				if (im.getCFGname().equals(objName)) {
					return im;
				}
			} else if (item instanceof ConfigChoice) {
				ConfigChoice cc = (ConfigChoice) item;
				List<ConfigItem> list = cc.getCGFchoice();
				for (ConfigItem cItem : list) {
					if (cItem.getCFGname().equals(objName)) {
						return cItem;
					}
				}
			}
		}
		return null;
	}
}
