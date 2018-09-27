package tonyx.EDI.Common.XMLSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.KeyFields;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreRec;
import tonyx.EDI.Common.XMLSyntax.Field;

final public class XMLRecord extends CoreRec implements ChildListOperate ,Cloneable {
	private ExplicitRule ediExplicitRule;
	private BlockSig ediBlockSig;
	private String ediRecordType;
	private String ediTag;
	private KeyFields ediKeyFields;

	private List<Object> childList;

	public XMLRecord() {
		childList = new ArrayList<Object>();
	}

	public List<Object> getChildList() {
		return childList;
	}

	public List<Object> getEdiField() {
		return childList;
	}

	public void setEdiField(Field field) {
		childList.add(field);
	}

	@Override
	public String toString() {
		return "Attributes";
	}

	@Override
	public XMLRecord clone() {
		XMLRecord xr = null;
		try {
			xr = (XMLRecord) super.clone();
			xr.setEdiBlockSig(xr.getEdiBlockSig().clone());
			xr.setEdiKeyFields(null);

			xr.setEdiExplicitRule(null);
			xr.childList = new ArrayList<Object>();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return xr;
	}

	public KeyFields getEdiKeyFields() {
		return ediKeyFields;
	}

	public void setEdiKeyFields(KeyFields ediKeyFields) {
		this.ediKeyFields = ediKeyFields;
	}

	public ExplicitRule getEdiExplicitRule() {
		return ediExplicitRule;
	}

	public void setEdiExplicitRule(ExplicitRule ediExplicitRule) {
		this.ediExplicitRule = ediExplicitRule;
	}

	public BlockSig getEdiBlockSig() {
		return ediBlockSig;
	}

	public void setEdiBlockSig(BlockSig ediBlockSig) {
		this.ediBlockSig = ediBlockSig;
	}

	public String getEdiRecordType() {
		return ediRecordType;
	}

	public void setEdiRecordType(String ediRecordType) {
		this.ediRecordType = ediRecordType;
	}

	public String getEdiTag() {
		return ediTag;
	}

	public void setEdiTag(String ediTag) {
		this.ediTag = ediTag;
	}
}
