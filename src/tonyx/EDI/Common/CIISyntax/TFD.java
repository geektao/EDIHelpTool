package tonyx.EDI.Common.CIISyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.KeyFields;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreRec;

public class TFD extends CoreRec implements ChildListOperate{
	private KeyFields ediKeyFields;
	private ExplicitRule ediExplicitRule;
	private BlockSig ediBlockSig;
	private List<Field> childList;

	public TFD() {
		childList = new ArrayList<Field>();
	}

	public List<Field> getChildList() {
		return childList;
	}

	public void setEdiField(Field field) {
		this.childList.add(field);
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
}
