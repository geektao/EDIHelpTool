package tonyx.EDI.Common.VarDelimSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.KeyFields;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreRec;

public class VarDelimRecord extends CoreRec implements ChildListOperate{
	private ExplicitRule ediExplicitRule;
	private KeyFields ediKeyFields;
	private BlockSig ediBlockSig;
	private List<Field> childList;

	public VarDelimRecord() {
		childList = new ArrayList<Field>();
	}

	public List<Field> getChildList() {
		return childList;
	}

	public void setChildList(Field field) {
		this.childList.add(field);
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

	public BlockSig getEdiBlockSig() {
		return ediBlockSig;
	}

	public void setEdiBlockSig(BlockSig ediBlockSig) {
		this.ediBlockSig = ediBlockSig;
	}
}
