package tonyx.EDI.Common.SwiftSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.ElementCore;

public class Composite extends ElementCore implements ChildListOperate{
	private String ediMandatory;
	private String ediMinUsage;
	private String ediMaxUsage;
	private String ediTreatAsRepeat;
	private String ediStartDelimiter;
	private String ediEndDelimiter;
	private String ediCompositeType;
	private List<Field> childList;

	public Composite() {
		childList = new ArrayList<Field>();
	}

	public List<Field> getChildList() {
		return childList;
	}

	public void setEdiField(Field field) {
		childList.add(field);
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

	public String getEdiStartDelimiter() {
		return ediStartDelimiter;
	}

	public void setEdiStartDelimiter(String ediStartDelimiter) {
		this.ediStartDelimiter = ediStartDelimiter;
	}

	public String getEdiEndDelimiter() {
		return ediEndDelimiter;
	}

	public void setEdiEndDelimiter(String ediEndDelimiter) {
		this.ediEndDelimiter = ediEndDelimiter;
	}

	public String getEdiCompositeType() {
		return ediCompositeType;
	}

	public void setEdiCompositeType(String ediCompositeType) {
		this.ediCompositeType = ediCompositeType;
	}
}
