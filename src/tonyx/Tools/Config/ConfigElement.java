package tonyx.Tools.Config;

final public class ConfigElement {
	private String CFGname;
	private String CFGclass;
	private ConfigSequence CFGsequence;

	public String getCFGclass() {
		return CFGclass;
	}

	public void setCFGclass(String cFGclass) {
		CFGclass = cFGclass;
	}

	public ConfigSequence getCFGsequence() {
		return CFGsequence;
	}

	public void setCFGsequence(ConfigSequence cFGsequence) {
		CFGsequence = cFGsequence;
	}

	public String getCFGname() {
		return CFGname;
	}

	public void setCFGname(String cFGname) {
		CFGname = cFGname;
	}
}
