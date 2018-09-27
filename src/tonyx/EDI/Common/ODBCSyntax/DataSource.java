package tonyx.EDI.Common.ODBCSyntax;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
	private String ediName;
	private String ediConnectString;
	private String ediDatabaseName;
	private String ediDSN;
	private String ediUID;
	private String ediPWD;
	private String ediPWD_encrypted_flag;
	private String ediDB;
	private String ediAttemptToConnect;
	private String ediUseTransactions;
	private List<Table> ediTable;

	public DataSource() {
		ediTable = new ArrayList<Table>();
	}

	public String getEdiName() {
		return ediName;
	}

	public void setEdiName(String ediName) {
		this.ediName = ediName;
	}

	public String getEdiConnectString() {
		return ediConnectString;
	}

	public void setEdiConnectString(String ediConnectString) {
		this.ediConnectString = ediConnectString;
	}

	public String getEdiDatabaseName() {
		return ediDatabaseName;
	}

	public void setEdiDatabaseName(String ediDatabaseName) {
		this.ediDatabaseName = ediDatabaseName;
	}

	public String getEdiDSN() {
		return ediDSN;
	}

	public void setEdiDSN(String ediDSN) {
		this.ediDSN = ediDSN;
	}

	public String getEdiUID() {
		return ediUID;
	}

	public void setEdiUID(String ediUID) {
		this.ediUID = ediUID;
	}

	public String getEdiPWD() {
		return ediPWD;
	}

	public void setEdiPWD(String ediPWD) {
		this.ediPWD = ediPWD;
	}

	public String getEdiPWD_encrypted_flag() {
		return ediPWD_encrypted_flag;
	}

	public void setEdiPWD_encrypted_flag(String ediPWD_encrypted_flag) {
		this.ediPWD_encrypted_flag = ediPWD_encrypted_flag;
	}

	public String getEdiDB() {
		return ediDB;
	}

	public void setEdiDB(String ediDB) {
		this.ediDB = ediDB;
	}

	public String getEdiAttemptToConnect() {
		return ediAttemptToConnect;
	}

	public void setEdiAttemptToConnect(String ediAttemptToConnect) {
		this.ediAttemptToConnect = ediAttemptToConnect;
	}

	public String getEdiUseTransactions() {
		return ediUseTransactions;
	}

	public void setEdiUseTransactions(String ediUseTransactions) {
		this.ediUseTransactions = ediUseTransactions;
	}

	public List<Table> getEdiTable() {
		return ediTable;
	}

	public void setEdiTable(Table ediTable) {
		this.ediTable.add(ediTable);
	}
}
