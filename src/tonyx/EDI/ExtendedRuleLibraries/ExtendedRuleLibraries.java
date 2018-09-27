package tonyx.EDI.ExtendedRuleLibraries;

import java.util.ArrayList;
import java.util.List;

final public class ExtendedRuleLibraries {
	private List<Object> ediExtendedRuleLibraryName;

	public ExtendedRuleLibraries() {
		ediExtendedRuleLibraryName = new ArrayList<Object>();
	}

	public List<Object> getEdiExtendedRuleLibraryName() {
		return ediExtendedRuleLibraryName;
	}

	public void setEdiExtendedRuleLibraryName(String extendedRuleLibraryName) {
		this.ediExtendedRuleLibraryName.add(extendedRuleLibraryName);
	}
}
