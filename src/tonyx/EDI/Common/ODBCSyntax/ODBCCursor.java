package tonyx.EDI.Common.ODBCSyntax;

import tonyx.EDI.Common.Base.CoreRec;

public class ODBCCursor extends CoreRec {
	private BlockSig ediBlockSig;
	private String ediCursorOperation;
	private String ediStatementRecordName;

	public BlockSig getEdiBlockSig() {
		return ediBlockSig;
	}

	public void setEdiBlockSig(BlockSig ediBlockSig) {
		this.ediBlockSig = ediBlockSig;
	}

	public String getEdiStatementRecordName() {
		return ediStatementRecordName;
	}

	public void setEdiStatementRecordName(String ediStatementRecordName) {
		this.ediStatementRecordName = ediStatementRecordName;
	}

	public String getEdiCursorOperation() {
		return ediCursorOperation;
	}

	public void setEdiCursorOperation(String ediCursorOperation) {
		this.ediCursorOperation = ediCursorOperation;
	}
}
