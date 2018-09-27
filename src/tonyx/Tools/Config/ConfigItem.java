package tonyx.Tools.Config;

final public class ConfigItem {
	private String CFGname;
	private String CFGversion;
	private String CFGvalueType;
	private String CFGclass;
	private ConfigElement CFGElement;
	private String CFGref;
	private String CFGminOccurs;
	private String CFGmaxOccurs;

	public String getCFGname() {
		return CFGname;
	}

	public void setCFGname(String cFGname) {
		CFGname = cFGname;
	}

	public String getCFGversion() {
		return CFGversion;
	}

	public void setCFGversion(String cFGversion) {
		CFGversion = cFGversion;
	}

	public String getCFGvalueType() {
		return CFGvalueType;
	}

	public void setCFGvalueType(String cFGvalueType) {
		CFGvalueType = cFGvalueType;
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

	public String getCFGclass() {
		return CFGclass;
	}

	public void setCFGclass(String cFGclass) {
		CFGclass = cFGclass;
	}

	public String getCFGref() {
		return CFGref;
	}

	public void setCFGref(String cFGref) {
		CFGref = cFGref;
	}

	public ConfigElement getCFGElement() {
		return CFGElement;
	}

	public void setCFGElement(ConfigElement cFGElement) {
		CFGElement = cFGElement;
	}
}
