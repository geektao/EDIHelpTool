package tonyx.EDI.Common.ODBCSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreRec;

public class ODBCInputRecord extends CoreRec implements ChildListOperate{
	private ExplicitRule ediExplicitRule;
	private BlockSig ediBlockSig;
	private KeyFields ediKeyFields;
	
	private List<Field> childList;
	
	public ODBCInputRecord(){
		childList = new ArrayList<Field>();
	}

	public List<Field> getChildList() {
		return childList;
	}

	public void setEdiField(Field field) {
		this.childList.add(field);
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

	public KeyFields getEdiKeyFields() {
		return ediKeyFields;
	}

	public void setEdiKeyFields(KeyFields ediKeyFields) {
		this.ediKeyFields = ediKeyFields;
	}	
}
