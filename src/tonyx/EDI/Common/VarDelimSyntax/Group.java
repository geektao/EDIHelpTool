package tonyx.EDI.Common.VarDelimSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreGroup;

final public class Group extends CoreGroup implements ChildListOperate, Cloneable {
	private List<Object> childList;
	
	public Group() {
		childList = new ArrayList<Object>();
	}
	public List<Object> getChildList() {
		return childList;
	}
	
	public void setEdiVarDelimRecord(VarDelimRecord varDelimRecord){
		childList.add(varDelimRecord);
	}
	
	public void setEdiField(Field field){
		childList.add(field);
	}
}
