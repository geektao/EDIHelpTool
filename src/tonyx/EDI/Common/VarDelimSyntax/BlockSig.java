package tonyx.EDI.Common.VarDelimSyntax;

import java.util.ArrayList;
import java.util.List;

public class BlockSig {
	private int index;
	private List<String> ediTag;
	private List<String> ediFieldNum;
	private List<String> ediFieldID;
	private List<String> ediFieldData;
	private List<String> ediFieldAction;

	public void setIndex(Integer index) {
		this.index = index;
	}

	public BlockSig() {
		setIndex(0);
		ediTag = new ArrayList<String>(2);
		ediFieldNum = new ArrayList<String>(2);
		ediFieldID = new ArrayList<String>(2);
		ediFieldData = new ArrayList<String>(2);
		ediFieldAction = new ArrayList<String>(2);
	}

	public String getEdiTag() {
		return ediTag.get(index);
	}

	public void setEdiTag(String ediTag) {
		this.ediTag.add(ediTag);
	}

	public String getEdiFieldNum() {
		return ediFieldNum.get(index);
	}

	public void setEdiFieldNum(String ediFieldNum) {
		this.ediFieldNum.add(ediFieldNum);
	}

	public String getEdiFieldID() {
		return ediFieldID.get(index);
	}

	public void setEdiFieldID(String ediFieldID) {
		this.ediFieldID.add(ediFieldID);
	}

	public String getEdiFieldData() {
		return ediFieldData.get(index);
	}

	public void setEdiFieldData(String ediFieldData) {
		this.ediFieldData.add(ediFieldData);
	}

	public String getEdiFieldAction() {
		return ediFieldAction.get(index);
	}

	public void setEdiFieldAction(String ediFieldAction) {
		this.ediFieldAction.add(ediFieldAction);
	}
}
