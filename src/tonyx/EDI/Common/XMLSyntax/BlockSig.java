package tonyx.EDI.Common.XMLSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.Tools.Utilities.DeepCopy;

final public class BlockSig implements Cloneable {
	private int index;
	private List<String> ediTagIndex;
	private List<String> ediNamespaceIndex;
	private List<String> ediBlockType;
	private List<String> ediFlags;
	private List<String> ediPadding;
	private List<String> ediKeyFieldID;
	private List<String> ediKeyFieldData;
	private List<String> ediKeyFieldAction;

	public BlockSig() {
		index = 0;
		ediTagIndex = new ArrayList<String>();
		ediNamespaceIndex = new ArrayList<String>();
		ediBlockType = new ArrayList<String>();
		ediFlags = new ArrayList<String>();
		ediPadding = new ArrayList<String>();
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
			bs.ediTagIndex = (List<String>) DeepCopy.ListDeepCopy(ediTagIndex);
			bs.ediNamespaceIndex = (List<String>) DeepCopy
					.ListDeepCopy(ediNamespaceIndex);
			bs.ediBlockType = (List<String>) DeepCopy
					.ListDeepCopy(ediBlockType);
			bs.ediFlags = (List<String>) DeepCopy.ListDeepCopy(ediFlags);
			bs.ediPadding = (List<String>) DeepCopy.ListDeepCopy(ediPadding);
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

	public String getEdiTagIndex() {
		return ediTagIndex.get(index);
	}

	public void setEdiTagIndex(String ediTagIndex) {
		this.ediTagIndex.add(ediTagIndex);
	}

	public String getEdiNamespaceIndex() {
		return ediNamespaceIndex.get(index);
	}

	public void setEdiNamespaceIndex(String ediNamespaceIndex) {
		this.ediNamespaceIndex.add(ediNamespaceIndex);
	}

	public String getEdiBlockType() {
		return ediBlockType.get(index);
	}

	public void setEdiBlockType(String ediBlockType) {
		this.ediBlockType.add(ediBlockType);
	}

	public String getEdiFlags() {
		return ediFlags.get(index);
	}

	public void setEdiFlags(String ediFlags) {
		this.ediFlags.add(ediFlags);
	}

	public String getEdiPadding() {
		return ediPadding.get(index);
	}

	public void setEdiPadding(String ediPadding) {
		this.ediPadding.add(ediPadding);
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
