package tonyx.EDI.Common.EDISyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.ElementCore;

final public class Composite extends ElementCore implements ChildListOperate , Cloneable {
	private String ediMandatory;
	private String ediMinUsage;
	private String ediMaxUsage;
	private String ediTreatAsRepeat;

	private List<Field> childList;

	public Composite() {
		childList = new ArrayList<Field>();
	}

	@Override
	public String toString() {
		if (ediMaxUsage.equals("1")) {
			return this.getEdiName() + " - " + isMandatory() + " - "
					+ this.getEdiDescription();
		}
		return this.getEdiName() + " - " + isMandatory() + " - "
				+ this.getEdiMaxUsage() + " " + this.getEdiDescription();
	}

	private String isMandatory() {
		if ("yes".equals(getEdiMandatory())) {
			return "M";
		}
		return "C";
	}

	public List<Field> getChildList() {
		return childList;
	}

	public List<Field> getEdiField() {
		return childList;
	}

	public void setEdiField(Field field) {
		childList.add(field);
	}

	@Override
	public Composite clone() {
		Composite obj = null;
		try {
			obj = (Composite) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public String getEdiMandatory() {
		return ediMandatory;
	}

	public void setEdiMandatory(String ediMandatory) {
		this.ediMandatory = ediMandatory;
	}

	public String getEdiMinUsage() {
		return ediMinUsage;
	}

	public void setEdiMinUsage(String ediMinUsage) {
		this.ediMinUsage = ediMinUsage;
	}

	public String getEdiMaxUsage() {
		return ediMaxUsage;
	}

	public void setEdiMaxUsage(String ediMaxUsage) {
		this.ediMaxUsage = ediMaxUsage;
	}

	public String getEdiTreatAsRepeat() {
		return ediTreatAsRepeat;
	}

	public void setEdiTreatAsRepeat(String ediTreatAsRepeat) {
		this.ediTreatAsRepeat = ediTreatAsRepeat;
	}
}
