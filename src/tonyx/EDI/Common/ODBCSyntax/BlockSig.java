package tonyx.EDI.Common.ODBCSyntax;

import java.util.ArrayList;
import java.util.List;

public class BlockSig {
	private int index;
	private List<String> ediBlockType;
	private List<String> ediDsnID;
	private List<String> ediCommand;
	private List<String> ediVerb;
	private List<String> ediCursorOperation;
	private List<String> ediKeyFieldAction;
	private List<String> ediStmtID;
	private List<String> ediTableID;
	private List<String> ediKeyFieldID;
	private List<String> ediKeyFieldData;
	private List<String> ediKeyFieldData2;
	private List<String> ediKeyFieldID2;
	private List<String> ediKeyFieldData3;
	private List<String> ediKeyFieldData4;
	private List<String> ediKeyFieldID3;
	private List<String> ediKeyFieldData5;
	private List<String> ediKeyFieldData6;

	public BlockSig() {
		ediBlockType = new ArrayList<String>(2);
		ediDsnID = new ArrayList<String>(2);
		ediCommand = new ArrayList<String>(2);
		ediVerb = new ArrayList<String>(2);
		ediCursorOperation = new ArrayList<String>(2);
		ediKeyFieldAction = new ArrayList<String>(2);
		ediStmtID = new ArrayList<String>(2);
		ediTableID = new ArrayList<String>(2);
		ediKeyFieldID = new ArrayList<String>(2);
		ediKeyFieldData = new ArrayList<String>(2);
		ediKeyFieldData2 = new ArrayList<String>(2);
		ediKeyFieldID2 = new ArrayList<String>(2);
		ediKeyFieldData3 = new ArrayList<String>(2);
		ediKeyFieldData4 = new ArrayList<String>(2);
		ediKeyFieldID3 = new ArrayList<String>(2);
		ediKeyFieldData5 = new ArrayList<String>(2);
		ediKeyFieldData6 = new ArrayList<String>(2);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getEdiBlockType() {
		return ediBlockType.get(index);
	}

	public void setEdiBlockType(String ediBlockType) {
		this.ediBlockType.add(ediBlockType);
	}

	public String getEdiDsnID() {
		return ediDsnID.get(index);
	}

	public void setEdiDsnID(String ediDsnID) {
		this.ediDsnID.add(ediDsnID);
	}

	public String getEdiCommand() {
		return ediCommand.get(index);
	}

	public void setEdiCommand(String ediCommand) {
		this.ediCommand.add(ediCommand);
	}

	public String getEdiVerb() {
		return ediVerb.get(index);
	}

	public void setEdiVerb(String ediVerb) {
		this.ediVerb.add(ediVerb);
	}

	public String getEdiCursorOperation() {
		return ediCursorOperation.get(index);
	}

	public void setEdiCursorOperation(String ediCursorOperation) {
		this.ediCursorOperation.add(ediCursorOperation);
	}

	public String getEdiKeyFieldAction() {
		return ediKeyFieldAction.get(index);
	}

	public void setEdiKeyFieldAction(String ediKeyFieldAction) {
		this.ediKeyFieldAction.add(ediKeyFieldAction);
	}

	public String getEdiStmtID() {
		return ediStmtID.get(index);
	}

	public void setEdiStmtID(String ediStmtID) {
		this.ediStmtID.add(ediStmtID);
	}

	public String getEdiTableID() {
		return ediTableID.get(index);
	}

	public void setEdiTableID(String ediTableID) {
		this.ediTableID.add(ediTableID);
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

	public String getEdiKeyFieldData2() {
		return ediKeyFieldData2.get(index);
	}

	public void setEdiKeyFieldData2(String ediKeyFieldData2) {
		this.ediKeyFieldData2.add(ediKeyFieldData2);
	}

	public String getEdiKeyFieldID2() {
		return ediKeyFieldID2.get(index);
	}

	public void setEdiKeyFieldID2(String ediKeyFieldID2) {
		this.ediKeyFieldID2.add(ediKeyFieldID2);
	}

	public String getEdiKeyFieldData3() {
		return ediKeyFieldData3.get(index);
	}

	public void setEdiKeyFieldData3(String ediKeyFieldData3) {
		this.ediKeyFieldData3.add(ediKeyFieldData3);
	}

	public String getEdiKeyFieldData4() {
		return ediKeyFieldData4.get(index);
	}

	public void setEdiKeyFieldData4(String ediKeyFieldData4) {
		this.ediKeyFieldData4.add(ediKeyFieldData4);
	}

	public String getEdiKeyFieldID3() {
		return ediKeyFieldID3.get(index);
	}

	public void setEdiKeyFieldID3(String ediKeyFieldID3) {
		this.ediKeyFieldID3.add(ediKeyFieldID3);
	}

	public String getEdiKeyFieldData5() {
		return ediKeyFieldData5.get(index);
	}

	public void setEdiKeyFieldData5(String ediKeyFieldData5) {
		this.ediKeyFieldData5.add(ediKeyFieldData5);
	}

	public String getEdiKeyFieldData6() {
		return ediKeyFieldData6.get(index);
	}

	public void setEdiKeyFieldData6(String ediKeyFieldData6) {
		this.ediKeyFieldData6.add(ediKeyFieldData6);
	}
}
