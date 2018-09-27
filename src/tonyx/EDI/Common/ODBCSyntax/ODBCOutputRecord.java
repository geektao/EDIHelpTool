package tonyx.EDI.Common.ODBCSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.ExplicitRule;
import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreRec;

public class ODBCOutputRecord  extends CoreRec implements ChildListOperate{
	private ExplicitRule ediExplicitRule;
	private KeyFields ediKeyFields;
	private BlockSig ediBlockSig;
	private String ediDataSourceName;
	private String ediTableName;
	private String ediSQLVerb;
	private String ediAutoChangeAndRetry;
	private List<Field> childList;
	
	public ODBCOutputRecord(){
		childList = new ArrayList<Field>();
	}
	
	public List<Field> getChildList() {
		return childList;
	}

	public void setEdiField(Field field) {
		this.childList.add(field);
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

	public String getEdiDataSourceName() {
		return ediDataSourceName;
	}

	public void setEdiDataSourceName(String ediDataSourceName) {
		this.ediDataSourceName = ediDataSourceName;
	}

	public String getEdiTableName() {
		return ediTableName;
	}

	public void setEdiTableName(String ediTableName) {
		this.ediTableName = ediTableName;
	}

	public String getEdiSQLVerb() {
		return ediSQLVerb;
	}

	public void setEdiSQLVerb(String ediSQLVerb) {
		this.ediSQLVerb = ediSQLVerb;
	}

	public String getEdiAutoChangeAndRetry() {
		return ediAutoChangeAndRetry;
	}

	public void setEdiAutoChangeAndRetry(String ediAutoChangeAndRetry) {
		this.ediAutoChangeAndRetry = ediAutoChangeAndRetry;
	}
}
