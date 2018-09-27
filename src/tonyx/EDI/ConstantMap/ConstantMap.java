package tonyx.EDI.ConstantMap;

import java.util.ArrayList;
import java.util.List;

final public class ConstantMap {
	private List<Constant> ediConstant;

	public ConstantMap() {
		ediConstant = new ArrayList<Constant>();
	}

	public List<Constant> getEdiConstant() {
		return ediConstant;
	}

	public void setEdiConstant(Constant constant) {
		this.ediConstant.add(constant);
	}
}
