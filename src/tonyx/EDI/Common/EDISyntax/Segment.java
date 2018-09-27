package tonyx.EDI.Common.EDISyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.KeyFields;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreRec;
import tonyx.EDI.Common.EDISyntax.BlockSig;
import tonyx.EDI.Common.EDISyntax.Composite;
import tonyx.EDI.Common.EDISyntax.Field;

final public class Segment extends CoreRec implements  ChildListOperate,Cloneable {
	private BlockSig ediBlockSig;
	private String ediWildCard;
	private String ediBinary;
	private String ediFloat;
	private ExplicitRule ediExplicitRule;
	private KeyFields ediKeyFields;

	// store Composite,field
	private List<Object> childList;

	public Segment() {
		childList = new ArrayList<Object>();
	}

	public List<Object> getChildList() {
		return childList;
	}

	public void setEdiField(Field field) {
		childList.add(field);
	}

	public void setEdiComposite(Composite composite) {
		childList.add(composite);
	}

	@Override
	public Segment clone() {
		Segment seg = null;
		try {
			seg = (Segment) super.clone();
			seg.setEdiBlockSig(seg.getEdiBlockSig().clone());
			seg.setEdiExplicitRule(null);
			seg.setEdiKeyFields(null);
			seg.childList = new ArrayList<Object>();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return seg;
	}

	public BlockSig getEdiBlockSig() {
		return ediBlockSig;
	}

	public void setEdiBlockSig(BlockSig ediBlockSig) {
		this.ediBlockSig = ediBlockSig;
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
