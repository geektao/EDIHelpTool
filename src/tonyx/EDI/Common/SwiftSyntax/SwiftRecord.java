package tonyx.EDI.Common.SwiftSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.KeyFields;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreRec;

public class SwiftRecord extends CoreRec implements ChildListOperate{
	private ExplicitRule ediExplicitRule;
	private KeyFields ediKeyFields;
	private BlockSig ediBlockSig;
	private String ediStartDelimiter;
	private String ediEndDelimiter;
	private String ediChoiceType;
	private String ediFieldSyntax;
	private List<Object> childList;

	public SwiftRecord() {
		childList = new ArrayList<Object>();
	}

	public List<Object> getChildList() {
		return childList;
	}

	public void setEdiComposite(Composite composite) {
		childList.add(composite);
	}

	public void setEdiField(Field field) {
		childList.add(field);
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

	public String getEdiChoiceType() {
		return ediChoiceType;
	}

	public void setEdiChoiceType(String ediChoiceType) {
		this.ediChoiceType = ediChoiceType;
	}

	public String getEdiFieldSyntax() {
		return ediFieldSyntax;
	}

	public void setEdiFieldSyntax(String ediFieldSyntax) {
		this.ediFieldSyntax = ediFieldSyntax;
	}
}
