package tonyx.EDI.Common.XMLSyntax;

import java.util.ArrayList;
import java.util.List;

import tonyx.Tools.Utilities.DeepCopy;

final public class NamespacePrefixes implements Cloneable {
	private List<NameSpacePrefix> ediNameSpacePrefix;

	@SuppressWarnings("unchecked")
	@Override
	public NamespacePrefixes clone() throws CloneNotSupportedException {
		NamespacePrefixes nps = (NamespacePrefixes) super.clone();
		nps.ediNameSpacePrefix = (List<NameSpacePrefix>) DeepCopy
				.ListDeepCopy(ediNameSpacePrefix);
		return nps;
	}

	public List<NameSpacePrefix> getDataObject() {
		return ediNameSpacePrefix;
	}

	public NamespacePrefixes() {
		ediNameSpacePrefix = new ArrayList<NameSpacePrefix>();
	}

	public List<NameSpacePrefix> getEdiNameSpacePrefix() {
		return ediNameSpacePrefix;
	}

	public void setEdiNameSpacePrefix(NameSpacePrefix ediNameSpacePrefix) {
		this.ediNameSpacePrefix.add(ediNameSpacePrefix);
	}
}
