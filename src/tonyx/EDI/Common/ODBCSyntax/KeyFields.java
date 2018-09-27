package tonyx.EDI.Common.ODBCSyntax;

import java.util.ArrayList;
import java.util.List;

public class KeyFields {
	private List<KeyField> ediKeyField;
	
	public KeyFields(){
		ediKeyField = new ArrayList<KeyField>(3);
	}

	public List<KeyField> getEdiKeyField() {
		return ediKeyField;
	}

	public void setEdiKeyField(KeyField ediKeyField) {
		this.ediKeyField.add(ediKeyField);
	}
}
