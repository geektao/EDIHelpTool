package tonyx.EDI.Common.CIISyntax;

import java.util.ArrayList;
import java.util.List;

public class BlockSig {
	private int index;
	private List<String> ediTag;
	private List<String> ediKeyFieldID;
	private List<String> ediKeyFieldData;
	private List<String> ediKeyFieldAction;
	private List<String> ediType;
	private List<String> ediFiller;

	public BlockSig() {
		index = 0;
		ediTag = new ArrayList<String>(2);
		ediKeyFieldID = new ArrayList<String>(2);
		ediKeyFieldData = new ArrayList<String>(2);
		ediKeyFieldAction = new ArrayList<String>(2);
		ediType = new ArrayList<String>(2);
		ediFiller = new ArrayList<String>(2);
	}

	public void setIndex(Integer ind) {
		index = ind;
	}

	public String getEdiTag() {
		return ediTag.get(index);
	}

	public void setEdiTag(String ediTag) {
		this.ediTag.add(ediTag);
	}

	public String getEdiKeyFieldID() {
		return ediKeyFieldID.get(index);
	}

	public void setEdiKeyFieldID(String ediKeyFieldID) {
		this.ediKeyFieldID.add(ediKeyFieldID);
	}

	public String getEdiKeyFieldData() {
		return ediKeyFieldData.get(index);
	}

	public void setEdiKeyFieldData(String ediKeyFieldData) {
		this.ediKeyFieldData.add(ediKeyFieldData);
	}

	public String getEdiKeyFieldAction() {
		return ediKeyFieldAction.get(index);
	}

	public void setEdiKeyFieldAction(String ediKeyFieldAction) {
		this.ediKeyFieldAction.add(ediKeyFieldAction);
	}

	public String getEdiFiller() {
		return ediFiller.get(index);
	}

	public void setEdiFiller(String ediFiller) {
		this.ediFiller.add(ediFiller);
	}

	public String getEdiType() {
		return ediType.get(index);
	}

	public void setEdiType(String ediType) {
		this.ediType.add(ediType);
	}
}
