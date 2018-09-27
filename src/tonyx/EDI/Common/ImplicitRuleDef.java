package tonyx.EDI.Common;

import java.util.ArrayList;
import java.util.List;

final public class ImplicitRuleDef {
	// private UseCode ediUseCode;
	// private UseConstant ediUseConstant;
	// private UseSystemVariable ediUseSystemVariable;
	// private UseAccumulator ediUseAccumulator;
	// private UseLoopCount ediUseLoopCount;
	// private UseSelect ediUseSelect;
	// private UseUpdate ediUseUpdate;

	// private List<Object> childList;

	private List<Object> childList;

	public ImplicitRuleDef() {
		childList = new ArrayList<Object>();
	}

	// public List<Object> getDataObject() {
	// return childList;
	// }

	public List<Object> getChildList() {
		return childList;
	}

	// public void setChildList(List<Object> childList) {
	// this.childList = childList;
	// }
	// public UseCode getEdiUseCode() {
	// return ediUseCode;
	// }
	public void setEdiUseCode(UseCode ediUseCode) {
		// this.ediUseCode = ediUseCode;
		childList.add(ediUseCode);
	}

	// public UseConstant getEdiUseConstant() {
	// return ediUseConstant;
	// }

	public void setEdiUseConstant(UseConstant ediUseConstant) {
		// this.ediUseConstant = ediUseConstant;
		childList.add(ediUseConstant);
	}

	// public UseSystemVariable getEdiUseSystemVariable() {
	// return ediUseSystemVariable;
	// }
	public void setEdiUseSystemVariable(UseSystemVariable ediUseSystemVariable) {
		// this.ediUseSystemVariable = ediUseSystemVariable;
		childList.add(ediUseSystemVariable);
	}

	// public UseAccumulator getEdiUseAccumulator() {
	// return ediUseAccumulator;
	// }
	public void setEdiUseAccumulator(UseAccumulator ediUseAccumulator) {
		// this.ediUseAccumulator = ediUseAccumulator;
		childList.add(ediUseAccumulator);
	}

	// public UseSelect getEdiUseSelect() {
	// return ediUseSelect;
	// }
	public void setEdiUseSelect(UseSelect ediUseSelect) {
		// this.ediUseSelect = ediUseSelect;
		childList.add(ediUseSelect);
	}

	// public UseUpdate getEdiUseUpdate() {
	// return ediUseUpdate;
	// }
	public void setEdiUseUpdate(UseUpdate ediUseUpdate) {
		// this.ediUseUpdate = ediUseUpdate;
		childList.add(ediUseUpdate);
	}

	// public UseLoopCount getEdiUseLoopCount() {
	// return ediUseLoopCount;
	// }
	public void setEdiUseLoopCount(UseLoopCount ediUseLoopCount) {
		// this.ediUseLoopCount = ediUseLoopCount;
		childList.add(ediUseLoopCount);
	}
}
