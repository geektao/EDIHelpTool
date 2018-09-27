package tonyx.EDI.Common.SPEC2000Syntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreGroup;

public class GroupSPEC extends CoreGroup implements ChildListOperate{
	private String ediGroupDelimiter;
	private List<Object> childList;
	
	public GroupSPEC(){
		childList  = new ArrayList<Object>();
	}
	
	public String getEdiGroupDelimiter() {
		return ediGroupDelimiter;
	}
	public void setEdiGroupDelimiter(String ediGroupDelimiter) {
		this.ediGroupDelimiter = ediGroupDelimiter;
	}
	public List<Object> getChildList() {
		return childList;
	}
	
	public void setEdiGroupSPEC(GroupSPEC groupSPEC){
		childList.add(groupSPEC);
	}
	
	public void setEdiSPECRecord(SPECRecord specRecord){
		childList.add(specRecord);
	}
}
