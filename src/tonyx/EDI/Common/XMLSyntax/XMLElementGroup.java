package tonyx.EDI.Common.XMLSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.ElementCore;
import tonyx.EDI.Common.XMLSyntax.NamespacePrefixes;

final public class XMLElementGroup extends ElementCore implements ChildListOperate, Cloneable {
	private String ediMin;
	private String ediMax;
	private String ediPromoteGroup;
	private String ediXMLTag;
	private String ediAllowAnyContent;
	private String ediAbstract;
	private String ediLink;
	private String ediNamespace;
	private String ediUseParentNamespace;
	private NamespacePrefixes ediNamespacePrefixes;
	private ExplicitRule ediExplicitRule;

	// store XMLElementGroup,XMLParticleGroup,XMLRecord
	private List<Object> childList;

	@Override
	public XMLElementGroup clone() {
		XMLElementGroup xmleleGroup = null;
		try {
			xmleleGroup = (XMLElementGroup) super.clone();
			if (ediNamespacePrefixes != null) {
				xmleleGroup.setEdiNamespacePrefixes(ediNamespacePrefixes
						.clone());
			}

			xmleleGroup.setEdiExplicitRule(null);
			xmleleGroup.childList = new ArrayList<Object>();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return xmleleGroup;
	}

	@Override
	public String toString() {
		return this.getEdiName() + " " + isCanRepeat() + " "
				+ getEdiDescription();
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

	public XMLElementGroup() {
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

	public String getEdiXMLTag() {
		return ediXMLTag;
	}

	public void setEdiXMLTag(String ediXMLTag) {
		this.ediXMLTag = ediXMLTag;
	}

	public String getEdiAllowAnyContent() {
		return ediAllowAnyContent;
	}

	public void setEdiAllowAnyContent(String ediAllowAnyContent) {
		this.ediAllowAnyContent = ediAllowAnyContent;
	}

	public String getEdiAbstract() {
		return ediAbstract;
	}

	public void setEdiAbstract(String ediAbstract) {
		this.ediAbstract = ediAbstract;
	}

	public String getEdiUseParentNamespace() {
		return ediUseParentNamespace;
	}

	public void setEdiUseParentNamespace(String ediUseParentNamespace) {
		this.ediUseParentNamespace = ediUseParentNamespace;
	}

	public String getEdiNamespace() {
		return ediNamespace;
	}

	public void setEdiNamespace(String ediNamespace) {
		this.ediNamespace = ediNamespace;
	}

	public NamespacePrefixes getEdiNamespacePrefixes() {
		return ediNamespacePrefixes;
	}

	public void setEdiNamespacePrefixes(NamespacePrefixes ediNamespacePrefixes) {
		this.ediNamespacePrefixes = ediNamespacePrefixes;
	}

	public String getEdiLink() {
		return ediLink;
	}

	public void setEdiLink(String ediLink) {
		this.ediLink = ediLink;
	}

	public ExplicitRule getEdiExplicitRule() {
		return ediExplicitRule;
	}

	public void setEdiExplicitRule(ExplicitRule ediExplicitRule) {
		this.ediExplicitRule = ediExplicitRule;
	}
}
