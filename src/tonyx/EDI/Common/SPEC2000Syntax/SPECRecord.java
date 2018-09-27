package tonyx.EDI.Common.SPEC2000Syntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.KeyFields;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreRec;

public class SPECRecord extends CoreRec implements ChildListOperate{
	private ExplicitRule ediExplicitRule;
	private KeyFields ediKeyFields;
	private BlockSig ediBlockSig;
	private String ediTEICanBeMissing;
	private String ediChoiceType;
	private String ediWildCard;
	private String ediBinary;
	private String ediFloat;
	private List <Field> ediField;
	
	public SPECRecord(){
		ediField = new ArrayList<Field>();
	}
	
	public List <Field> getChildList() {
		return ediField;
	}
	public void setEdiField(Field ediField) {
		this.ediField.add(ediField);
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

	public String getEdiTEICanBeMissing() {
		return ediTEICanBeMissing;
	}

	public void setEdiTEICanBeMissing(String ediTEICanBeMissing) {
		this.ediTEICanBeMissing = ediTEICanBeMissing;
	}

	public String getEdiChoiceType() {
		return ediChoiceType;
	}

	public void setEdiChoiceType(String ediChoiceType) {
		this.ediChoiceType = ediChoiceType;
	}

	public String getEdiWildCard() {
		return ediWildCard;
	}

	public void setEdiWildCard(String ediWildCard) {
		this.ediWildCard = ediWildCard;
	}

	public String getEdiBinary() {
		return ediBinary;
	}

	public void setEdiBinary(String ediBinary) {
		this.ediBinary = ediBinary;
	}

	public String getEdiFloat() {
		return ediFloat;
	}

	public void setEdiFloat(String ediFloat) {
		this.ediFloat = ediFloat;
	}
}
