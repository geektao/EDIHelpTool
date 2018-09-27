package tonyx.EDI.Common.EDISyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.Tools.Utilities.DeepCopy;

final public class BlockSig implements Cloneable {
	private int index;
	private List<String> ediTag;
	private List<String> ediTagPos;
	private List<String> ediKeyFieldID;
	private List<String> ediKeyFieldData;
	private List<String> ediKeyFieldAction;

	public BlockSig() {
		index = 0;
		ediTag = new ArrayList<String>();
		ediTagPos = new ArrayList<String>();
		ediKeyFieldID = new ArrayList<String>();
		ediKeyFieldData = new ArrayList<String>();
		ediKeyFieldAction = new ArrayList<String>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public BlockSig clone() {
		BlockSig bs = null;
		try {
			bs = (BlockSig) super.clone();
			bs.ediTag = (List<String>) DeepCopy.ListDeepCopy(ediTag);
			bs.ediTagPos = (List<String>) DeepCopy.ListDeepCopy(ediTagPos);
			bs.ediKeyFieldID = (List<String>) DeepCopy
					.ListDeepCopy(ediKeyFieldID);
			bs.ediKeyFieldData = (List<String>) DeepCopy
					.ListDeepCopy(ediKeyFieldData);
			bs.ediKeyFieldAction = (List<String>) DeepCopy
					.ListDeepCopy(ediKeyFieldAction);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return bs;
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

	public String getEdiTagPos() {
		return ediTagPos.get(index);
	}

	public void setEdiTagPos(String ediTagPos) {
		this.ediTagPos.add(ediTagPos);
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
}
