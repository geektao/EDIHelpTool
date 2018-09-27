package tonyx.EDI.Common.PosSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.KeyFields;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreRec;
import tonyx.EDI.Common.PosSyntax.BlockSig;
import tonyx.EDI.Common.PosSyntax.Field;

final public class PosRecord extends CoreRec implements ChildListOperate, Cloneable {
	private ExplicitRule ediExplicitRule;
	private KeyFields ediKeyFields;
	private BlockSig ediBlockSig;
	private String ediTagLength;

	private List<Object> childList;

	public PosRecord() {
		childList = new ArrayList<Object>();
	}

	@Override
	public PosRecord clone() {
		PosRecord pr = null;
		try {
			pr = (PosRecord) super.clone();
			pr.setEdiKeyFields(null);
			pr.setEdiBlockSig(ediBlockSig.clone());
			pr.setEdiExplicitRule(null);
			pr.childList = new ArrayList<Object>();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return pr;
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

	public BlockSig getEdiBlockSig() {
		return ediBlockSig;
	}

	public void setEdiBlockSig(BlockSig ediBlockSig) {
		this.ediBlockSig = ediBlockSig;
	}

	public String getEdiTagLength() {
		return ediTagLength;
	}

	public void setEdiTagLength(String ediTagLength) {
		this.ediTagLength = ediTagLength;
	}

	public ExplicitRule getEdiExplicitRule() {
		return ediExplicitRule;
	}

	public void setEdiExplicitRule(ExplicitRule ediExplicitRule) {
		this.ediExplicitRule = ediExplicitRule;
	}

	public KeyFields getEdiKeyFields() {
		return ediKeyFields;
	}

	public void setEdiKeyFields(KeyFields ediKeyFields) {
		this.ediKeyFields = ediKeyFields;
	}
}
