package tonyx.EDI.Common.EDISyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.EDI.Common.Base.ChildListOperate;
import tonyx.EDI.Common.Base.CoreGroup;
import tonyx.EDI.Common.EDISyntax.Composite;

final public class Group extends CoreGroup implements ChildListOperate,Cloneable {
	// store group,segment,Composite
	private List<Object> childList;

	@Override
	public Group clone() {
		Group group = null;
		try {
			group = (Group) super.clone();
			group.childList = new ArrayList<Object>();
			group.setEdiExplicitRule(null);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return group;
	}

	public Group() {
		childList = new ArrayList<Object>();
	}

	public List<Object> getChildList() {
		return childList;
	}

	public void setEdiGroup(Group group) {
		childList.add(group);
	}

	public void setEdiSegment(Segment segment) {
		childList.add(segment);
	}

	public void setEdiComposite(Composite composite) {
		childList.add(composite);
	}
}
