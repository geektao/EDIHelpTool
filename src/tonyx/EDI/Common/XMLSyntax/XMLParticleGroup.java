package tonyx.EDI.Common.XMLSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.ElementCore;

final public class XMLParticleGroup extends ElementCore implements ChildListOperate, Cloneable {
	private String ediMin;
	private String ediMax;
	private String ediPromoteGroup;
	private String ediParticleType;
	private ExplicitRule ediExplicitRule;

	@Override
	public String toString() {
		return this.getEdiName() + " " + isCanRepeat() + " "
				+ getEdiDescription();
	}

	@Override
	public XMLParticleGroup clone() {
		XMLParticleGroup xmlparGroup = null;
		try {
			xmlparGroup = (XMLParticleGroup) super.clone();
			xmlparGroup.setEdiExplicitRule(null);
			xmlparGroup.childList = new ArrayList<Object>();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return xmlparGroup;
	}

	private String isCanRepeat() {
		if (ediMin.equals("0")) {
			if (ediMax.equals("-1")) {
				return "*";
			} else if (ediMax.equals("1")) {
				return "?";
			} else {
				return "* (" + ediMax + ")";
			}
		} else {
			if (ediMax.equals("-1")) {
				return "+";
			} else if (ediMax.equals("1")) {
				return "";
			} else {
				return "+ (" + ediMax + ")";
			}
		}
	}

	// store XMLElementGroup,XMLRecord
	private List<Object> childList;

	public XMLParticleGroup() {
		childList = new ArrayList<Object>();
	}

	public List<Object> getChildList() {
		return childList;
	}

	public void setEdiXMLElementGroup(XMLElementGroup xmlElementGroup) {
		childList.add(xmlElementGroup);
	}

	public void setEdiXMLParticleGroup(XMLParticleGroup xmlParticleGroup) {
		childList.add(xmlParticleGroup);
	}

	public void setEdiXMLRecord(XMLRecord xmlRecord) {
		childList.add(xmlRecord);
	}

	public String getEdiMin() {
		return ediMin;
	}

	public void setEdiMin(String ediMin) {
		this.ediMin = ediMin;
	}

	public String getEdiMax() {
		return ediMax;
	}

	public void setEdiMax(String ediMax) {
		this.ediMax = ediMax;
	}

	public String getEdiPromoteGroup() {
		return ediPromoteGroup;
	}

	public void setEdiPromoteGroup(String ediPromoteGroup) {
		this.ediPromoteGroup = ediPromoteGroup;
	}

	public String getEdiParticleType() {
		return ediParticleType;
	}

	public void setEdiParticleType(String ediParticleType) {
		this.ediParticleType = ediParticleType;
	}

	public ExplicitRule getEdiExplicitRule() {
		return ediExplicitRule;
	}

	public void setEdiExplicitRule(ExplicitRule ediExplicitRule) {
		this.ediExplicitRule = ediExplicitRule;
	}
}
